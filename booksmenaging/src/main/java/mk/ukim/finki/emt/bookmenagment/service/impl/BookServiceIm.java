package mk.ukim.finki.emt.bookmenagment.service.impl;

import mk.ukim.finki.emt.bookmenagment.domain.exception.BookNotFoundException;
import mk.ukim.finki.emt.bookmenagment.domain.model.Book;
import mk.ukim.finki.emt.bookmenagment.domain.model.BookId;
import mk.ukim.finki.emt.bookmenagment.domain.repository.BookRepository;
import mk.ukim.finki.emt.bookmenagment.service.BookService;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIm implements BookService {
    final BookRepository bookRepository;

    public BookServiceIm(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(BookId id) {
        return this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book create(String bookName, String authorName, String img, String synapse, Money price, String genre, int sales) {
        Book book = Book.build(bookName, authorName, img, synapse, price, genre, sales);
        return bookRepository.save(book);
    }

    @Override
    public Book update(BookId id ,String bookName, String authorName, String img, String synapse, Money price, String genre, int sales) {
        Book book = findById(id);
        this.bookRepository.delete(book);
        Book x = Book.build(bookName, authorName, img, synapse, price, genre, sales);
        return bookRepository.save(x);
    }

    @Override
    public Book delete(BookId id) {
        Book book = findById(id);
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public List<Book> filter(String filter) {
        return this.bookRepository.findAllByBookNameContainingOrAuthorNameContainingOrGenreContaining(filter,filter,filter);

    }
}
