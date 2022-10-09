import React from "react";
import imgBook from"./img/book.png";
import imgBasket from"./img/basket.png";
import books from "../Books/books";
import "./nav.css"


const  nav = (props) => {
    return(

        <header className="p-3 mb-3 border-bottom">
            <div className="container">
                <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                    <a className="navbar-brand" href="/books">
                        <img src="https://free.clipartof.com/1078-Free-Clipart-Of-Hands-Holding-A-Bible-Or-Book.jpg" className="w-40 h-30"/>
                    </a>

                    <a href="/" className="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">

                    </a>

                    <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><a  href="/books" className="nav-link px-2 link-dark">Products</a></li>
                        <li><a  href="/cart" className="nav-link px-2 link-dark">Cart</a></li>

                    </ul>

                    <div className="nav col-3 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <input type="text" className="form-control" placeholder="Search.." aria-label="Username"
                               aria-describedby="addon-wrapping" style={{width: "200px"}} />
                        <button className="btn btn-dark" >
                            <a id="/books" href="/search">Search</a>
                        </button>
                    </div>



                    <button className="btn btn-outline-dark" >
                        <a id="links" href="/login">Log in</a>
                    </button>

                    <button  style={{marginLeft: "10px"}} className="btn btn-outline-dark" >
                        <a id="links" href="/register">Register</a>
                    </button>


                </div>
            </div>
        </header>




)
}

export default nav;