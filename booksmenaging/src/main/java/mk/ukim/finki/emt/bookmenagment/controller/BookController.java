package mk.ukim.finki.emt.bookmenagment.controller;

import mk.ukim.finki.emt.bookmenagment.domain.model.Book;
import mk.ukim.finki.emt.bookmenagment.domain.model.BookId;
import mk.ukim.finki.emt.bookmenagment.service.BookService;
import mk.ukim.finki.emt.sharedkernel.service.Currency;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping()
    public List<Book> findAll() {
        return bookService.listAll();
    }

    @PostMapping("/{id}/delete")
    public List<Book> delete(@PathVariable String id) {
        this.bookService.delete(BookId.of(id));
        return bookService.listAll();
    }

    @PostMapping("/{id}/edit")
    public List<Book> edit(@PathVariable String id,
                           @RequestParam String bookName,
                           @RequestParam String authorName,
                           @RequestParam String img,
                           @RequestParam String synapse,
                           @RequestParam Currency currency,
                           @RequestParam double amount,
                           @RequestParam String genre,
                           @RequestParam int sales) {
        this.bookService.update(BookId.of(id), bookName, authorName, img, synapse, new Money(currency,amount), genre, sales);
        return bookService.listAll();

    }


    @PostMapping("/add")
    public List<Book> add(@RequestParam String bookName,
                          @RequestParam String authorName,
                          @RequestParam String img,
                          @RequestParam String synapse,
                          @RequestParam Currency currency,
                          @RequestParam double amount,
                          @RequestParam String genre,
                          @RequestParam int sales) {
        this.bookService.create(bookName, authorName, img, synapse, new Money(currency,amount), genre, sales);
        return bookService.listAll();
    }


    @GetMapping("/")
    public List<Book> filter(@RequestParam String filter ) {
        Double x = Double.parseDouble(filter);


        return bookService.filter(filter);
    }



}

