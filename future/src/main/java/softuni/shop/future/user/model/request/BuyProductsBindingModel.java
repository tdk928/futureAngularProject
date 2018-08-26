package softuni.shop.future.user.model.request;

public class BuyProductsBindingModel {
    private String id;

    private String quantity;

    public BuyProductsBindingModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
