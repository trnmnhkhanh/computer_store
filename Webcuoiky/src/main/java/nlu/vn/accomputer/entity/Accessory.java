package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "accessory")
@Getter
@Setter
@ToString
public class Accessory extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "name", columnDefinition = "TEXT")
    @JsonIgnore
    private String name;

    @ManyToOne  // nhieu san pham thuoc 1 loai
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Category category;

    @NumberFormat(pattern = "#")
    @Column(name = "quantity")
    @Min(0)
    @JsonIgnore
    private int quantity;

    @JsonIgnore
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToOne(mappedBy = "accessory",cascade = CascadeType.ALL) //mot san pham co nhieu anh
    @JsonIgnore
    private Image image;

    @ManyToOne(fetch = FetchType.EAGER) // nhieu san pham thuoc 1 nha san xuat
    @JsonIgnore
    @JoinColumn(name = "manufacturer_id")
    @EqualsAndHashCode.Exclude
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "accessory") //mot san pham co the nam trong nhieu chi tiet don hang
    @JsonIgnore
    private Collection<BillDetail> details;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Price price;


    public Accessory() {
    }

}
