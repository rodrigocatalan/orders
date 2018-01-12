package br.com.tecnogroup.rcatalan.orders.order;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class OrderBatch {

    @Size(min=1, max=10)
    private List<Order> orders = new ArrayList<>();

    public OrderBatch() {
    }

    public OrderBatch(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
