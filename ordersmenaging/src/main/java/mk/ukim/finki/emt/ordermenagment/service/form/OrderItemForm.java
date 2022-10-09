package mk.ukim.finki.emt.ordermenagment.service.form;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.ordermenagment.domain.valueobjects.Book;

@Data
public class OrderItemForm {

    @NotNull
    private Book book;

    private int quantity = 1;
}
