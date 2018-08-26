package softuni.shop.future.admin.service.impl;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import softuni.shop.future.admin.repository.AdminRepository;
import softuni.shop.future.admin.service.api.AdminService;
import softuni.shop.future.app.util.DTOConverter;
import softuni.shop.future.product.model.entity.Product;
import softuni.shop.future.product.model.request.CreateProductModel;
import softuni.shop.future.product.model.request.EditProductModel;
import softuni.shop.future.product.repository.ProductRepository;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.request.AllUsersDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static softuni.shop.future.app.util.AppConstants.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private ProductRepository productRepository;

    public AdminServiceImpl(AdminRepository adminRepository, ProductRepository productRepository) {
        this.adminRepository = adminRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean deleteProduct(String id) {
        Product product = this.productRepository.findFirstById(id);
        this.adminRepository.findAll().stream().forEach(u -> {
            while (u.getProducts().contains(product)) {
                u.getProducts().remove(product);
                this.adminRepository.save(u);
            }
        });
        this.productRepository.delete(product);
        return true;
    }

    @Override
    public ResponseEntity<?> createProduct(CreateProductModel createModel, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(this.processErrors(errors), HttpStatus.BAD_REQUEST);
        }

        this.persistNewProduct(createModel);

        return new ResponseEntity<>(new Gson().toJson(SUCCESSFULLY_ADD_PRODUCT), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editProduct(EditProductModel editProductModel, String id, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(this.processErrors(errors), HttpStatus.BAD_REQUEST);
        }
        this.persistEditedProduct(editProductModel);
        return new ResponseEntity<>(new Gson().toJson(SUCCESSFULLY_EDITED_PRODUCT), HttpStatus.CREATED);

    }


    @Override
    public List<User> findAll() {
        return this.adminRepository.findAll();
    }

    private Map<String, String> processErrors(Errors errors) {
        Map<String, String> errorsByField = new HashMap<>();
        for (FieldError current : errors.getFieldErrors())
            errorsByField.put(current.getField(), current.getDefaultMessage());
        return errorsByField;
    }

    @Override
    public List<AllUsersDTO> getAllUsers() {
        List<User> users = this.adminRepository.findAll();
        List<AllUsersDTO> allUsers = new ArrayList<>();
        for (User u : users) {
            allUsers.add(DTOConverter.convert(u, AllUsersDTO.class));
        }
        return allUsers;
    }

    @Override
    public boolean bannedUser(boolean isBanned, String id) {
        User user = this.adminRepository.findFirstById(Long.parseLong(id));
        user.setBanned(isBanned);
        this.adminRepository.save(user);
        return true;
    }

    private void persistEditedProduct(EditProductModel editProductModel) {
        Product product = DTOConverter.convert(editProductModel,Product.class);
        product.setLastModified(LocalDate.now());
        this.productRepository.save(product);
    }

    private void persistNewProduct(CreateProductModel createModel) {
        Product product = DTOConverter.convert(createModel, Product.class);
        this.productRepository.save(product);
    }
}
