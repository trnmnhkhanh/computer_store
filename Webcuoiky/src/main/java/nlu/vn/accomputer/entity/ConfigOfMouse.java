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
@Table(name = "mouse_config")
public class ConfigOfMouse extends Auditable {

    private String connect; //cong ket noi
    private String need; //nhau cau su dung

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

}
