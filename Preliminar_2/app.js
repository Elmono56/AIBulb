const express = require('express');
const bodyParser = require('body-parser');
const { Kafka } = require('kafkajs');

const app = express();
const port = 3000;
const kafka = new Kafka({
    clientId: 'my-app',
    brokers: ['localhost:9092']
});

const producer = kafka.producer();


app.use(bodyParser.json());

app.post('/update-content', async (req, res) => {
    const { id, contenido } = req.body;

    if (!id) {
        return res.status(400).send('ID is required');
    }

    try {
        await producer.connect();

        await producer.send({
            topic: 'content-update',
            messages: [
                { key: String(id), value: JSON.stringify(contenido) }
            ]
        });

        await producer.disconnect();

        res.status(200).send('Content updated successfully');
    } catch (err) {
        console.error('Error updating content:', err);

        res.status(500).send('Error updating content');
    }
});

app.listen(port, () => {
    console.log(`API listening at http://localhost:${port}`);
});
