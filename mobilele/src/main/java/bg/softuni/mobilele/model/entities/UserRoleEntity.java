package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.entities.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class UserRoleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
