package br.com.tecnogroup.rcatalan.orders.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private OrderBusiness orderBusiness;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setOrderBusiness(OrderBusiness orderBusiness) {
        this.orderBusiness = orderBusiness;
    }

    public List<Order> getAll() {
        List<Order> list = new ArrayList<>();
        this.orderRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Order> save(List<Order> orders){
        List<Order> list = new ArrayList<>();
        this.orderRepository.save(orders).forEach(item-> {
                orderBusiness.findAndApplyDiscount( item );
                list.add(item);
            }
        );
        return list;
    }

    public List<Order> findByFields(Order order){
        return this.orderRepository.findByIdOrRefOrGeneretedAtOrProductNameOrProductValueOrAmountOrClientIdOrTotal(
                order.getId(), order.getRef(), order.getGeneretedAt(), order.getProductName(),
                order.getProductValue(), order.getAmount(), order.getClientId(), order.getTotal());
    }



}
