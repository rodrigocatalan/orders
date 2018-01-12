package br.com.tecnogroup.rcatalan.orders.order;

import org.springframework.stereotype.Service;

import static java.math.BigDecimal.*;

@Service
public class OrderBusiness {

    public OrderBusiness() {
    }

    public void findAndApplyDiscount(Order order){

        if ( order.getAmount() < 5 ) {
            order.setTotal();
        } else if ( order.getAmount() >= 10 ){
            order.discount( TEN );
        } else {
            order.discount( valueOf( 5 ) );
        }

    }

}
