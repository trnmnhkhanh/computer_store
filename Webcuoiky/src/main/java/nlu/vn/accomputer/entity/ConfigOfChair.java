package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "chair_config")
public class ConfigOfChair extends Auditable {

    private int height; // chieu cao ghe
    private int weight; // can nang co the
    private String material;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

}
