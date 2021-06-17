package nlu.vn.accomputer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "bill_detail")
@Getter
@Setter
@ToString
public class BillDetail extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    private double price ; //gia cua mot san pham
    private int amount; // so luong san pham

    @ManyToOne //nhieu chi tiet don thuoc  don
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne //nhieu chi tiet don hang co cung 1 san pham
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

}
