import React, {Component} from "react";
import "./addBook.css"
import axios from '../../../custom-axsios/axios';

class  addBook extends Component {

    constructor(props) {
        super();

        this.state = {
            bookName: "bookName",
            authorName: "authorName",
            img: "img",
            synapse: "synapse",
            currency: "currency",
            amount: "amount" ,
            genre:"genre" ,
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e =>{
        e.preventDefault()
        axios.post("/add", this.state)
    }

    render() {
        const {bookName,authorName, img, synapse, currency,amount, genre  } = this.state;

        return (

            <form className="form-horizontal" onSubmit={this.submitHandler}>
                <div className="form-group">
                    <label className="control-label col-sm-2" htmlFor="email">Book Name:</label>
                    <div className="col-sm-10">
                        <input name="bookName" value={bookName} placeholder="Book Name" onChange={this.changeHandler} />
                    </div>
                </div>
                <div className="form-group">
                    <label className="control-label col-sm-2">Author Name:</label>
                    <div className="col-sm-10">
                        <input name="authorName" value={authorName} placeholder="Author Name" onChange={this.changeHandler}/>
                    </div>
                </div>

                <div className="form-group">
                    <label className="control-label col-sm-2">Image Link:</label>
                    <div className="col-sm-10">
                        <input name="img" value={img} placeholder="Image Link" onChange={this.changeHandler}/>
                    </div>
                </div>

                <div className="form-group">
                    <label className="control-label col-sm-2">Synapse:</label>
                    <div className="col-sm-10">
                        <textarea name="synapse" value={synapse} placeholder="Synapse" onChange={this.changeHandler}/>
                    </div>
                </div>

                <div className="form-group">
                    <label className="control-label col-sm-2">Currency:</label>
                    <div className="col-sm-10">
                        <textarea name="currency" value={currency} placeholder="MKD or EUR" onChange={this.changeHandler}/>
                    </div>
                </div>

                <div className="form-group">
                    <label className="control-label col-sm-2">Amount:</label>
                    <div className="col-sm-10">
                        <textarea name="amount" value={amount} placeholder="Amount" onChange={this.changeHandler}/>
                    </div>
                </div>


                <div className="form-group">
                    <label className="control-label col-sm-2">Genre:</label>
                    <div className="col-sm-10">
                        <textarea name="genre" value={genre} placeholder="Genre" onChange={this.changeHandler} />
                    </div>
                </div>

                <button type="submit">
                    <a >
                        Add the Book
                    </a>
                </button>


            </form>
        );
    }
}

export default addBook;