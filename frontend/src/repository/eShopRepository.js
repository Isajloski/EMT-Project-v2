import axios from '../custom-axsios/axios';


const EShopService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchOrders: ()=>{
        return axios.get("/orders");
    },
    fetchUsers: () =>{
        return axios.get("/users");
    },
    deleteBook:(id) =>{
        return axios.post(`/books/${id}/delete`); //api/books/id/delete
    }
}

export default EShopService;


