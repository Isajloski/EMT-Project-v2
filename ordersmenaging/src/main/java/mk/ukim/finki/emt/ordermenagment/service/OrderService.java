package mk.ukim.finki.emt.ordermenagment.service;

import mk.ukim.finki.emt.ordermenagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermenagment.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermenagment.domain.model.Order;
import mk.ukim.finki.emt.ordermenagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermenagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermenagment.service.form.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;




}
