package nlu.vn.accomputer.entity;


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
@ToString
public class Price extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "price")
    private double price;

    @Column(name = "sale_price")
    private double salePrice;

    @OneToOne(cascade = CascadeType.ALL)
    private Accessory accessory;

   private int salePercent;

    private double purchasePrice;


    public Price() {
    }


}
