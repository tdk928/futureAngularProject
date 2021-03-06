package softuni.shop.future.product.model.request;

import softuni.shop.future.product.model.entity.Color;
import softuni.shop.future.product.model.entity.Tag;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class CreateProductModel {
    private static final int TITLE_LENGTH = 1;
    private String id;

    @NotBlank
    @Size(min = TITLE_LENGTH)
    private String title;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9-_/\\\\.:]+\\.(jpg|png)$")
    private String imageUrl;

//    @NotBlank
    @Min(1)
    private double price;

    private Set<Tag> tags;

    private Set<Color> colors;

    @NotBlank
    @Size(max = 255)
    private String description;

    private String purpose;



    public CreateProductModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
