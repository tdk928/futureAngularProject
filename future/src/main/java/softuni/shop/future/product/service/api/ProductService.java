package softuni.shop.future.product.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import softuni.shop.future.product.model.entity.Product;
import softuni.shop.future.product.model.request.CreateProductModel;

import java.util.List;

public interface ProductService {
    ResponseEntity<?> createProduct(CreateProductModel createModel, Errors errors);

    List<Product> getProductsByGenre(String genre);

    Product getProductById(String id);

    List<Product> getAllProducts();
}
