import React from "react";


const  books = (props) => {

    return (

        <div className="row">
        {props.books.map((term) => {
            return (
                    <div className="card" style={{width:"33%"}}>
                        <img src= {term.img} style={{height:"600px"}}  alt={ term.id.id}/>
                        <div className="card-body">
                            <h5 className="card-title">{term.bookName}</h5>
                            <p className="card-text">{term.synapse}</p>

                            <button className="btn btn-outline-dark" >
                                <a>in stock: {term.sales}</a>
                            </button>

                            <button className="btn btn-outline-dark" >
                                <a id="links" href="/login">Add in cart</a>
                            </button>

                            <button className="btn btn-outline-dark" >
                                <a onClick={() => props.onDelete(term.id.id)}>
                                    Delete
                                </a>
                            </button>

                            <button className="btn btn-outline-dark" >
                                <a>Edit</a>
                            </button>

                        </div>
                    </div>




                );
            })}


        </div>


);
}

export default books;