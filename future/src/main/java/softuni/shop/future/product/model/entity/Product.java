package softuni.shop.future.product.model.entity;

import org.hibernate.annotations.GenericGenerator;
import softuni.shop.future.user.model.entity.User;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static softuni.shop.future.app.util.AppConstants.UUID;
import static softuni.shop.future.app.util.AppConstants.UUID_GENERATOR;

@Entity
@Table(name = "products")
public class Product {
    private static final String ID = "ID";
    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(
            name = UUID,
            strategy = UUID_GENERATOR
    )
    @Column(name = ID, updatable = false, nullable = false)
    private String id;


    @GeneratedValue(strategy = GenerationType.TABLE)
    private long numberOrder;

    private String imageUrl;

    private double price;

    private String title;

//    @ManyToMany
//    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(long numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.getTags().add(tag);
        this.setTags(this.getTags());
    }

    public void clearTags() {
        this.setTags(new HashSet<>());
    }
}
