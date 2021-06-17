package nlu.vn.accomputer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persistent_logins")
@Getter
@Setter
@ToString
public class PersistentLogin implements Serializable {
    private static final long serialVersionUID = 1L;


    @Basic(optional = false)
    @Column(name = "username", length = 65)
    private String username;

    @Id
    @Basic(optional = false)
    @Column(name = "series", length = 65)
    private String series;

    @Basic(optional = false)
    @Column(name = "token", length = 65)
    private String token;

    @Basic(optional = false)
    @Column(name = "last_used")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public PersistentLogin() {
    }

    public PersistentLogin(String username, String series, String token, Date date) {
        this.username = username;
        this.series = series;
        this.token = token;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

}
