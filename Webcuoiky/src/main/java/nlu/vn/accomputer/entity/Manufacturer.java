package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "manufacturer")
@ToString
@Getter
@Setter
public class Manufacturer extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name="name")
    private String name;

    @Basic(optional = false)
    @Column(name="image")
    private String image;

    @Column(name = "is_hidden")
    private boolean isHidden;



    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Accessory> accessories;

    public Manufacturer() {
    }

}
