package nlu.vn.accomputer.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "role_id")
    private int roleId;

    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;


    @ManyToMany(mappedBy = "roles")
    private List<Account> accounts = new ArrayList<>();

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}



