package mk.ukim.finki.emt.bookmenagment.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.service.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.service.Currency;
import mk.ukim.finki.emt.sharedkernel.service.Money;

import javax.persistence.*;

@Entity
@Table(name="books")
@Getter
public class Book extends AbstractEntity<BookId> {
    private String bookName;
    private int sales = 1;
    private String authorName;
    private String img;

    @Column(columnDefinition="TEXT")
    private String synapse;
    private String genre;

    @Embedded
    private Money price;

    public Book() {
        super(BookId.randomId(BookId.class));
        this.bookName = "bookName";
        this.authorName = "authorName";
        this.img = "img";
        this.synapse = "synapse";
        this.price = Money.valueOf(Currency.MKD,0);
        this.genre = "genre";

    }

    public static Book build(String bookName, String authorName, String img, String synapse, Money price, String genre, int sales) {
        Book book = new Book();
        book.bookName = bookName;
        book.authorName = authorName;
        book.img = img;
        book.synapse = synapse;
        book.price = price;
        book.genre = genre;
        book.sales = sales;
        return book;
    }

    public void addSales(int min) {
        this.sales = this.sales - min;
    }

    public void removeSales(int min) {
        this.sales -= min;
    }

}
