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
@Table(name = "screen_config")
public class ConfigOfScreen extends Auditable {


    private int size; //kich thuoc man hinh
    private boolean curved; // do cong man hinh
    private String resolution; //do phan giai, man hinh
    private boolean graphicScreen; //man hinh do hoa
    private int scanFrequency; //man hinh




    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;





}
