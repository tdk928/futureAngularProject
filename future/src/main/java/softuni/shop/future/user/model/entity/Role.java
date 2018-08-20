package softuni.shop.future.user.model.entity;


import org.hibernate.annotations.NaturalId;
import softuni.shop.future.user.model.enumeration.RoleName;

import javax.persistence.*;

import static softuni.shop.future.app.util.AppConstants.*;

@Entity
@Table(name = ROLES)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = ROLE_NAME_LENGH_VALUE, nullable = false)
    private RoleName name;

    public Role() {
    }


    public Role(RoleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}
