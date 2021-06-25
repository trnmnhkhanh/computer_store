package nlu.vn.accomputer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
public class IndexOfCart extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn()
    private Accessory accessory;

    private int quantity;

    @ManyToOne
    @JoinColumn
    private ShoppingCart shoppingCart;
}
