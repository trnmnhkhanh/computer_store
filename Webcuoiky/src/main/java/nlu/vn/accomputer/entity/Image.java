package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "image")
@Getter
@Setter

public class Image extends Auditable {
    @Column(name = "link")
    @JsonIgnore
    private String link;

    @OneToOne()
    @JoinColumn(name = "accessory_id")
    @JsonIgnore
    private Accessory accessory;

    @Override
    public String toString() {
        return "Image{" +
                "link='" + link + '\'' +
                '}';
    }
}
