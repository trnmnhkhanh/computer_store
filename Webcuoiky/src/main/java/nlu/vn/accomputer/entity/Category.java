package nlu.vn.accomputer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
public class Category extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;



    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Accessory> accessories;

    public Category() {
    }

}
