const { Kafka } = require('kafkajs');
const { MongoClient } = require('mongodb');

const kafka = new Kafka({
    clientId: 'my-app',
    brokers: ['localhost:9092']
});

const consumer = kafka.consumer({ groupId: 'content-update' });

const mongoUri = 'mongodb://root:example@localhost:27017,localhost:27018,localhost:27019/mydatabase?replicaSet=rs0';
const client = new MongoClient(mongoUri, { useNewUrlParser: true, useUnifiedTopology: true });

async function updateContent(id, contenido) {
    try {
        await client.connect();

        const db = client.db();
        const collection = db.collection('usuarios');

        await collection.updateOne(
            { id: id },
            { $set: { content: contenido } },
            { upsert: true }
        );

        await client.close();
    } catch (err) {
        console.error('Error updating content:', err);
    }
}

async function run() {
    await consumer.connect();
    await consumer.subscribe({ topic: 'content-update', fromBeginning: false });

    try {
        await consumer.run({
            eachMessage: async ({ topic, partition, message }) => {
                const id = parseInt(message.key);
                const contenido = JSON.parse(message.value);
                await updateContent(id, contenido);
            }
        });
    } catch (err) {
        console.error('Error running consumer:', err);
    } finally {
        await consumer.disconnect();
    }
}

run().catch(console.error);
