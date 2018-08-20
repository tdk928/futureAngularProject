package softuni.shop.future.admin.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import softuni.shop.future.product.model.request.CreateProductModel;
import softuni.shop.future.product.service.api.ProductService;
import softuni.shop.future.user.service.api.UserService;

import javax.validation.Valid;

import static softuni.shop.future.app.util.AppConstants.*;


@RestController
@RequestMapping(ADMIN_URL)
@PreAuthorize(IS_ADMIN)
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping(USERS_URL)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(CREATE_URL)
    public ResponseEntity<?> addProduct(@Valid @RequestBody CreateProductModel createModel, Errors errors) {
        return new ResponseEntity<>(this.productService.createProduct(createModel,errors), HttpStatus.OK);
    }


}
