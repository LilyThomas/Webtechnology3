const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const MongoClient = require('mongodb').MongoClient

var db

//connect to mongodb
MongoClient.connect('mongodb://localhost:27017/products', (err, database) => {
    if(err) return console.log(err)
    db = database.db('products')
    app.listen(process.env.PORT || 3000, () => {
        console.log('Listening on port 3000')
    })
})

app.set('view engine', 'ejs')
app.use(bodyParser.urlencoded({extended:true}))
app.use(bodyParser.json())
app.use(express.static('public'))

//Redirect to list => startpage to /list
app.get('/', (req, res) => {
    res.redirect('/list')
})

//List all products => startpage
app.get('/list', (req, res) => {
    db.collection('products').find().toArray((err, result) => {
        if (err) return console.log(err)
        res.render('list.ejs', {products: result})
    })
})

//show the add product form => render to add form
app.get('/add', (req, res) => {
    res.render('add.ejs', {})
})

//add a product
app.post('/add', (req, res) => {
    db.collection('products').insertOne(req.body, (err, result) => {
        if (err) return console.log(err)
        res.redirect('/list')
    })
})

//show search form => render search form
app.get('/search', (req, res) => {
    res.render('search.ejs', {})
})

//search for product by name
app.post('/search', (req, res) => {
    var query = {name: req.body.name}
    db.collection('products').find(query).toArray((err, result) => {
        if(err) return console.log(err)
        if(result == '')
            res.render('search_not_found.ejs', {})
        else
            res.render('search_result.ejs', {product: result[0]})
    })
})

//delete a product
app.post('/delete', (req, res) => {
    db.collection('products').findOneAndDelete({name: req.body.name}, (err, result) => {
        if(err) return res.send(500, err)
        res.redirect('/list')
    })
})