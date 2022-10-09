package mk.ukim.finki.emt.ordermenagment.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermenagment.domain.valueobjects.Book;
import mk.ukim.finki.emt.sharedkernel.service.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import mk.ukim.finki.emt.sharedkernel.service.Currency;


import javax.persistence.*;
import java.time.Instant;
import java.util.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
    }

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Book book, int qty) {
        Objects.requireNonNull(book,"product must not be null");
        var item  = new OrderItem(book.getId(),book.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }
}



//@Entity
//@Getter
//@Table(name="orders")
//public class Order extends AbstractEntity<OrderId> {
//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<OrderItem> orderItemList = new HashSet<>();
//
//
//    private Instant orderedOn;
//
//    private Order() {
//        super(OrderId.randomId(OrderId.class));
//    }
//
//    public Money total() {
//        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(0), Money::add);
//    }
//
//    public Order(Instant now) {
//        super(OrderId.randomId(OrderId.class));
//        this.orderedOn = now;
//    }
//
//    public OrderItem addItem(@NonNull Book book, int qty) {
//        Objects.requireNonNull(book,"product must not be null");
//        var item  = new OrderItem(book.getId(),book.getPrice(),qty);
//        orderItemList.add(item);
//        return item;
//    }
//
//    public void removeItem(@NonNull OrderItemId orderItemId) {
//        Objects.requireNonNull(orderItemId,"Order Item must not be null");
//        orderItemList.removeIf(v->v.getId().equals(orderItemId));
//    }
//}
