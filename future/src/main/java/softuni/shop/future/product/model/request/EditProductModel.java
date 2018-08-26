package softuni.shop.future.product.model.request;

import softuni.shop.future.product.model.entity.Color;
import softuni.shop.future.product.model.entity.Tag;

import java.time.LocalDate;
import java.util.Set;

public class EditProductModel {
    private String id;

    private String imageUrl;

    private double price;

    private String title;

    private LocalDate lastModified;

    private long numberOrder;

    private Set<Tag> tags;

    private Set<Color> colors;

    private String purpose;

    private String description;

    private LocalDate dateAdded;

    public EditProductModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public long getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(long numberOrder) {
        this.numberOrder = numberOrder;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
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

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
