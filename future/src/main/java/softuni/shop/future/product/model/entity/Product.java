package softuni.shop.future.product.model.entity;

import org.hibernate.annotations.GenericGenerator;
import softuni.shop.future.user.model.entity.User;

import javax.persistence.*;

import java.time.LocalDate;
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

    private LocalDate lastModified;

//    @ManyToMany
//    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_colors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors;

    private String purpose;

    private String description;

    private LocalDate dateAdded;

    public Product() {
        this.setDateAdded(LocalDate.now());
        this.setLastModified(LocalDate.now());
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }


    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }
}
