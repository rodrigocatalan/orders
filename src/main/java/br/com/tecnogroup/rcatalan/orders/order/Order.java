package br.com.tecnogroup.rcatalan.orders.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import static java.math.BigDecimal.*;
import java.util.Calendar;

@Entity
@Table(name = "XORDER",
        uniqueConstraints=@UniqueConstraint(
            columnNames = "ref",
            name = "order_ref_uk")
        )
public class Order implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String ref;

    @NotNull
    private Calendar generetedAt = Calendar.getInstance();

    @Size(min = 1, max = 255)
    @NotEmpty
    private String productName;

    private BigDecimal productValue;

    @NotNull
    private Integer amount = 1;

    private Long clientId;

    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Calendar getGeneretedAt() {
        return generetedAt;
    }

    public void setGeneretedAt(Calendar generetedAt) {
        this.generetedAt = generetedAt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setTotal() {
        this.total = calculatedValue();
    }

    public BigDecimal calculatedValue() {
        return productValue.multiply( valueOf( amount ) );
    }

    public void discount(BigDecimal percentual) {
        BigDecimal value = valueOf(100)
                .subtract( percentual )
                .multiply( calculatedValue() )
                .divide( valueOf(100));

        this.setTotal( value );
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", generetedAt=" + generetedAt +
                ", productName='" + productName + '\'' +
                ", productValue=" + productValue +
                ", amount=" + amount +
                ", clientId=" + clientId +
                ", total=" + total +
                '}';
    }
}
