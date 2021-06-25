package nlu.vn.accomputer.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class ShoppingCart extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    private  Account account;

    public ShoppingCart() {
    }


}
