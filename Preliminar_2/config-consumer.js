const { Kafka } = require('kafkajs');
const { MongoClient } = require('mongodb');

const kafka = new Kafka({
    clientId: 'my-app',
    brokers: ['localhost:9092']
});

const consumer = kafka.consumer({ groupId: 'content-update' });
console.log('Testing consumer');
const mongoUri = 'mongodb://localhost:27017/AIBulb';
const client = new MongoClient(mongoUri, { useNewUrlParser: true, useUnifiedTopology: true });
console.log('Testing mongo');

async function updateContent(id, contenido) {
    console.log('Updating content');
    try {
        await client.connect();

        const db = client.db();
        const collection = db.collection('servicios');

        const fieldsToUpdate = Object.keys(contenido); // Obtener los nombres de los campos a actualizar
        const valuesToUpdate = Object.values(contenido); // Obtener los valores que se van a actualizar

        const updateObj = {};
        fieldsToUpdate.forEach((field, index) => {
            updateObj[field] = valuesToUpdate[index]; // Combinar las llaves y valores en un objeto
        });

        await collection.updateOne({ ID: id }, { $set: updateObj });

    } catch (err) {
        console.error('Error updating content:', err);
    } finally {
        console.log('Closing mongo client');
        await client.close();
    }
}


async function run() {
    await consumer.connect();
    await consumer.subscribe({ topic: 'content-update', fromBeginning: true });
    console.log('Testing consumer inside run()');
    await consumer.run({
        eachMessage: async ({ topic, partition, message }) => {
            console.log('Testing consumer inside run() async');
            // console.log(message);
            const id = message.key.toString();
            const contenido = JSON.parse(message.value.toString());
            console.log('Testing consumer inside run() after parse');
            await updateContent(id, contenido);
        },
    });
}

run().catch(console.error);
