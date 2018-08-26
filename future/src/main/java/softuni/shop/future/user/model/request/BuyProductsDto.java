package softuni.shop.future.user.model.request;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BuyProductsDto implements Serializable {
    @Expose
    private Set<BuyProductsBindingModel> buyProductsBindingModels;

    public BuyProductsDto() {
        this.buyProductsBindingModels = new HashSet<>();
    }

    public Set<BuyProductsBindingModel> getBuyProductsBindingModels() {
        return buyProductsBindingModels;
    }

    public void setBuyProductsBindingModels(Set<BuyProductsBindingModel> buyProductsBindingModels) {
        this.buyProductsBindingModels = buyProductsBindingModels;
    }
}
