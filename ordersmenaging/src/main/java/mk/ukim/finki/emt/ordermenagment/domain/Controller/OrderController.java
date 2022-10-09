package mk.ukim.finki.emt.ordermenagment.domain.Controller;

import mk.ukim.finki.emt.ordermenagment.domain.model.Order;
import mk.ukim.finki.emt.ordermenagment.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/order")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    List<Order> findAll(){
        return orderService.findAll();
    }



}
