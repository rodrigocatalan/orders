package br.com.tecnogroup.rcatalan.orders.order;

import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByIdOrRefOrGeneretedAtOrProductNameOrProductValueOrAmountOrClientIdOrTotal(
            Long id, String ref, Calendar generetedAt, String productName,
            BigDecimal productValue, Integer amount, Long clientId, BigDecimal total);

}
