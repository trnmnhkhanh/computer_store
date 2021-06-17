package nlu.vn.accomputer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@ToString
@Table(name = "kboard_config")
public class ConfigOfKeyboard extends Auditable {
    private String connect;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

}
