const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const path = require('path');

const app = express();
const port = 3000;

const db = mysql.createConnection({
    host: 'localhost',
    user: 'yourUsername',
    password: 'yourPassword',
    database: 'hosiimono'
});

db.connect(err => {
    if (err) throw err;
    console.log('MySQL connected...');
});

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));

app.get('/items', (req, res) => {
    db.query('SELECT * FROM items ORDER BY position', (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.post('/items', (req, res) => {
    const newItem = req.body;
    db.query('INSERT INTO items SET ?', newItem, (err, result) => {
        if (err) throw err;
        res.sendStatus(201);
    });
});

app.delete('/items/:id', (req, res) => {
    const { id } = req.params;
    db.query('DELETE FROM items WHERE id = ?', id, (err, result) => {
        if (err) throw err;
        res.sendStatus(200);
    });
});

app.put('/items/:id/position', (req, res) => {
    const { id } = req.params;
    const { position } = req.body;
    db.query('UPDATE items SET position = ? WHERE id = ?', [position, id], (err, result) => {
        if (err) throw err;
        res.sendStatus(200);
    });
});

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
