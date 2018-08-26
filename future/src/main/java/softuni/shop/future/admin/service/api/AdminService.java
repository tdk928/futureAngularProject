package softuni.shop.future.admin.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import softuni.shop.future.product.model.request.CreateProductModel;
import softuni.shop.future.product.model.request.EditProductModel;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.request.AllUsersDTO;

import java.util.List;

public interface AdminService {
    boolean deleteProduct(String id);

    ResponseEntity<?> createProduct(CreateProductModel createModel, Errors errors);

    ResponseEntity<?> editProduct(EditProductModel editProductModel, String id, Errors errors);

    List<User> findAll();

    List<AllUsersDTO> getAllUsers();

    boolean bannedUser(boolean isBanned, String id);
}
