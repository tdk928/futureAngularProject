package softuni.shop.future.user.model.request;

import softuni.shop.future.user.model.entity.Role;

import java.util.Set;

public class CurrentUserDto {
    private String id;
    private String username;
    private Set<Role> roles;

    public CurrentUserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
