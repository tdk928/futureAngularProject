package softuni.shop.future.user.model.entity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import softuni.shop.future.product.model.entity.Product;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static softuni.shop.future.app.util.AppConstants.*;


@Entity
@Table(name = USERS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                USERNAME
        }),
        @UniqueConstraint(columnNames = {
                EMAIL
        })
})
public class User {

    public static final String USER_PRODUCTS = "user_products";
    public static final String PRODUCT_ID = "product_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
//    @Min(USER_NAME_MIN_VALUE)
//    @Max(USER_NAME_MAX_VALUE)
    @Column(nullable = false, length = USER_NAME_MAX_VALUE)
    private String username;

    @NotBlank
//    @Max(EMAIL_MAX_VALUE)
    @Email
    @Column(unique = true, nullable = false, length = EMAIL_MAX_VALUE)
    private String email;

    @NotBlank
//    @Min(PASSWORD_MIN_VALUE)
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = USER_ROLES,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID))
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false)
    private Boolean isBanned = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = USER_PRODUCTS,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = PRODUCT_ID))
    private List<Product> products;



    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    @PrePersist
    public void onPrePersist() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }


    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}