import express from "express"
import mysql from "mysql"
import cors from "cors"

const app = express()

app.use(cors())

const dbc = mysql.createConnection({
	host: 'localhost',
	user: 'user',
	password: 'password',
	database: 'db'
})

dbc.connect();

app.listen('3000', () => {
	console.log('Server Started')
})

app.use('/image', express.static('public/images'));

app.get('/', (req, res) => {
	return res.send('성공')
});

app.get('/song', (req, res) => {
	const query = 'SELECT title, artist, image, agency, release_date FROM agency \
					LEFT JOIN artist ON agency.id=artist.ag_id \
					LEFT JOIN song ON artist.id=song.ar_id';
	dbc.query(query, (err, rows) => {
		if (err) return console.log(err);
		res.send(rows);
	})
});