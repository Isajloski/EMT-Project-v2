package mk.ukim.finki.emt.ordermenagment.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.ordermenagment.domain.valueobjects.BookId;
import mk.ukim.finki.emt.sharedkernel.service.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.service.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import org.springframework.lang.NonNull;

import javax.persistence.*;


@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Embedded
    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private BookId bookId;

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    public void setItemPrice(Money itemPrice) {
        this.itemPrice = itemPrice;
    }

    private OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull BookId productId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.bookId = productId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }
}


//@Entity
//@Table(name = "order_item")
//@Getter
//public class OrderItem extends AbstractEntity<OrderItemId> {
//
//
//    @Embedded
//    private Money itemPrice;
//
//    @Column(name = "qty", nullable = false)
//    private int quantity;
//
//    @Embedded
//    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
//    private BookId bookId;
//
//
//
//    public void setItemPrice(Money itemPrice) {
//        this.itemPrice = itemPrice;
//    }
//
//    public void setBookId(BookId bookId) {
//        this.bookId = bookId;
//    }
//
//    private OrderItem() {
//        super(DomainObjectId.randomId(OrderItemId.class));
//    }
//
//    public OrderItem(@NonNull BookId bookId, @NonNull Money itemPrice, int qty) {
//        super(DomainObjectId.randomId(OrderItemId.class));
//        this.bookId = bookId;
//        this.itemPrice = itemPrice;
//        this.quantity = qty;
//    }
//
//    public Money subtotal() {
//        return itemPrice.multiply(quantity);
//    }
//
//
//
//}