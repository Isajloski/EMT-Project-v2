package mk.ukim.finki.emt.ordermenagment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import mk.ukim.finki.emt.sharedkernel.service.ValueObject;
import mk.ukim.finki.emt.sharedkernel.service.Currency;

import javax.persistence.Embedded;

@Getter
public class Book implements ValueObject {

    private final BookId id;
    private final String bookName;
    private final String authorName;
    private final String img;
    private final String synapse;
    private final String genre;

    private final Money price;


    private final int sales = 0;


    private Book() {
        this.id = BookId.randomId(BookId.class);
        this.bookName = "";
        this.authorName ="";
        this.img = "";
        this.synapse = "";
        this.price = Money.valueOf(Currency.MKD,0);
        this.genre = "";
    }


    @JsonCreator
    public Book (@JsonProperty("id") BookId id,
                 @JsonProperty("bookName") String bookName,
                 @JsonProperty("authorName") String authorName,
                 @JsonProperty("img") String img,
                 @JsonProperty("synapse") String synapse,
                 @JsonProperty("price") Money price,
                 @JsonProperty("genre") String genre) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.img = img;
        this.synapse = synapse;
        this.price = price;
        this.genre = genre;
    }



}