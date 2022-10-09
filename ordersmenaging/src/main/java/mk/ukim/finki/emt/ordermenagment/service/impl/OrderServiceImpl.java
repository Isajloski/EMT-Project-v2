package mk.ukim.finki.emt.ordermenagment.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermenagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermenagment.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermenagment.domain.model.Order;
import mk.ukim.finki.emt.ordermenagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermenagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermenagment.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermenagment.service.OrderService;
import mk.ukim.finki.emt.ordermenagment.service.form.OrderForm;
import mk.ukim.finki.emt.ordermenagment.service.form.OrderItemForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.addItem(orderItemForm.getBook(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm) {
        var order = new Order(Instant.now(),orderForm.getCurrency());
        orderForm.getItems().forEach(item->order.addItem(item.getBook(),item.getQuantity()));
        return order;
    }


}
