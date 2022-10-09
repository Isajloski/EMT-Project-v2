package mk.ukim.finki.emt.ordermenagment.domain.repository;

import mk.ukim.finki.emt.ordermenagment.domain.model.Order;
import mk.ukim.finki.emt.ordermenagment.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {

}
