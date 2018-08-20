package softuni.shop.future.product.model.request;

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

    private Set<String> tags;



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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
