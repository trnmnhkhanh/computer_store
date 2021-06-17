package nlu.vn.accomputer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
public class Person extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private boolean gender;

    @Basic(optional = false)
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private Account account;

    // mot nguoi co nhieu dia chi
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Address> addresses;



    public Person() {
    }


}
