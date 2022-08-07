package bg.softuni.mobilelle.mobilelle.model.entities;

import bg.softuni.mobilelle.mobilelle.model.entities.BaseEntity;
import bg.softuni.mobilelle.mobilelle.model.entities.UserRoleEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, name = "username")
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToMany
    private List<UserRoleEntity> userRoles;

    private String imageUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", role=" + userRoles +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}