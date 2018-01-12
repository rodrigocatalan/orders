package br.com.tecnogroup.rcatalan.orders.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("orders")
    public List<Order> list() {
        List<Order> orders = this.orderService.getAll();
        return orders;
    }

    @RequestMapping(value = "orders/search", method = POST)
    public List<Order> list(@RequestBody Order order) {

        return this.orderService.findByFields( order );
    }

    @RequestMapping(value = "orders", method = POST)
    public List<Order> create(@Valid @RequestBody OrderBatch orders) {
        return this.orderService.save(orders.getOrders());
    }
}
