package mk.ukim.finki.emt.bookmenagment.service;

import mk.ukim.finki.emt.bookmenagment.domain.model.Book;
import mk.ukim.finki.emt.bookmenagment.domain.model.BookId;
import mk.ukim.finki.emt.sharedkernel.service.Money;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(BookId id);

    Book create(String bookName, String authorName, String img, String synapse, Money price, String genre, int sales);

    Book update(BookId id ,String bookName, String authorName, String img, String synapse, Money price, String genre, int sales);

    Book delete(BookId id);

    List<Book> filter(String something);

}


