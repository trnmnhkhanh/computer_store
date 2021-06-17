package nlu.vn.accomputer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "detail")
    private String detail;

    @OneToOne
    private Province province;
    @OneToOne
    private District district;

    //nhieu dia chi thuoc mot nguoi
    @ManyToOne
    @JoinColumn(name = "person_email",referencedColumnName = "email")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Person person;

    //mot don hang co mot dia chi
    @OneToOne
    private Bill bill;

    public Address() {
    }


}
