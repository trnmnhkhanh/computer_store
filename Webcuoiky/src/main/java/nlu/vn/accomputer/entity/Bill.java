package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "bill")
@Getter
@Setter
@ToString
public class Bill extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "totalprice")
    private double totalPrice;

    @Column
    private String note;

    @Column(name="status")
    private boolean status;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "bill",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Account account;

    //mot don hang co nhieu chi tiet don hang
    @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<BillDetail> details;

    public Bill() {
    }

}
