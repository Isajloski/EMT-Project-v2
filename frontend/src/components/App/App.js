import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Routes , Route} from 'react-router-dom';
import EShopService from "../../repository/eShopRepository";
import Orders from "../Orders/orders";
import Navbar from "../NavBar/nav";
import Books from "../Books/books";
import EditBook from "../Books/edit/editBook";
import AddBook from "../Books/add/addBook";






class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            orders: []
        }
    }

    render() {
        return (
            <div className="container">
                <Navbar/>
                <Router>
                    <Routes>
                        <Route path="/" element={<Books books = {this.state.books}/>}> </Route>
                        <Route path="/books" element={<Books books = {this.state.books} onDelete={this.deleteBooks}/>}>
                        </Route >
                        <Route path="/books/edit" element={<EditBook />}></Route>
                        <Route path="/books/add" element={<AddBook />}></Route>

                    </Routes>
                </Router>

            </div>
        );
    }

    loadBooks = () => {
        EShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
            })
            });
    }

    loadOrders =() =>{
        EShopService.fetchOrders()
            .then((data) => {
                this.setState({
                    orders: data.data
                })
            });
    }

    deleteBooks =(id) =>{
        EShopService.deleteBook(id)
            .then((data) => {
                this.loadBooks();
            });
    }

    componentDidMount() {
        this.loadBooks();
        this.loadOrders();
    }

}

export default App;

// <Router>
//     <Navbar/>
//     <main>
//         <div className="container">
//
//             <Routes>
//                 <Route path={"/books/"} render={() =>
//                     <Books books={this.state.books} />} />
//
//
//
//
//             </Routes>
//         </div>
//
//     </main>
// </Router>