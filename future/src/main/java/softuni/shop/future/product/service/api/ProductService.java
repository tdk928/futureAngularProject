package softuni.shop.future.product.service.api;

import softuni.shop.future.product.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductsByGenre(String genre);

    List<Product> getLastThreeProducts();

    Product getProductById(String id);

    List<Product> getAllProducts();


}
