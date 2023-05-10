const { Kafka } = require('kafkajs');
const { MongoClient } = require('mongodb');

const kafka = new Kafka({
    clientId: 'my-app',
    brokers: ['localhost:9092']
});

const consumer = kafka.consumer({ groupId: 'content-update' });

const mongoUri = 'mongodb://localhost:27017/mydatabase';
const client = new MongoClient(mongoUri, { useNewUrlParser: true, useUnifiedTopology: true });

async function updateContent(id, contenido) {
    try {
        await client.connect();

        const db = client.db();
        const collection = db.collection('usuarios');

        await collection.updateOne({ id: id }, { $set: { contenido } });

    } catch (err) {
        console.error('Error updating content:', err);
    } finally {
        await client.close();
    }
}

async function run() {
    await consumer.connect();
    await consumer.subscribe({ topic: 'content-update', fromBeginning: true });

    await consumer.run({
        eachMessage: async ({ topic, partition, message }) => {
            console.log(message);
            const content = message.value.toString();
            const parsedContent = JSON.parse(content);
            await updateContent(parsedContent.id, parsedContent.contenido);
        }
    });
}

run().catch(console.error);
