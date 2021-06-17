package nlu.vn.accomputer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "account")
@Getter
@Setter
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Transient
    private String repassword;

    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    @ManyToMany()
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "account")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Bill> bills = new HashSet<Bill>();


    public Account() {
    }

}
