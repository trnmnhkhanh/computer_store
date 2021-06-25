package nlu.vn.accomputer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "price")
@Getter
@Setter
public class Price extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @JsonIgnore
    @Column(name = "sale_price")
    private double salePrice;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Accessory accessory;
    @JsonIgnore
   private int salePercent;
    @JsonIgnore
    private double purchasePrice;


    public Price() {
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", salePrice=" + salePrice +
                ", salePercent=" + salePercent +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}
