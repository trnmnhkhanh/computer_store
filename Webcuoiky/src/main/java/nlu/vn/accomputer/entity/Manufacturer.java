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
@Getter
@Setter
public class Manufacturer extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Basic(optional = false)
    @Column(name="name")
    private String name;
    @JsonIgnore
    @Basic(optional = false)
    @Column(name="image")
    private String image;

    @JsonIgnore
    @Column(name = "is_hidden")
    private boolean isHidden;



    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
    private Collection<Accessory> accessories;

    public Manufacturer() {
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", isHidden=" + isHidden +
                '}';
    }
}
