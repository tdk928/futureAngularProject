package softuni.shop.future.admin.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import softuni.shop.future.admin.service.api.AdminService;
import softuni.shop.future.product.model.request.CreateProductModel;
import softuni.shop.future.product.model.request.EditProductModel;
import softuni.shop.future.product.service.api.ProductService;
import softuni.shop.future.user.service.api.UserService;

import javax.validation.Valid;

import static softuni.shop.future.app.util.AppConstants.*;


@RestController
@RequestMapping(ADMIN_URL)
@PreAuthorize(IS_ADMIN)
public class AdminController {
    private final ProductService productService;
    private final AdminService adminService;

    public AdminController(ProductService productService, AdminService adminService) {
        this.productService = productService;
        this.adminService = adminService;
    }

    @GetMapping(USERS_URL)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.adminService.findAll(), HttpStatus.OK);
    }

    @PostMapping(CREATE_URL)
    public ResponseEntity<?> addProduct(@Valid @RequestBody CreateProductModel createModel, Errors errors) {
        return new ResponseEntity<>(this.adminService.createProduct(createModel,errors), HttpStatus.OK);
    }

    @PostMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.adminService.deleteProduct(id), HttpStatus.OK);
    }

    @PostMapping("/product/edit/{id}")
    public ResponseEntity<?> editProduct(@Valid @RequestBody EditProductModel editModel,@PathVariable("id") String id,Errors errors) {
        return new ResponseEntity<>(this.adminService.editProduct(editModel,id,errors), HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity<?> allUsers() {
        return new ResponseEntity<>(this.adminService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/banned/{id}")
    public ResponseEntity<?> bannedUser(@RequestBody boolean isBanned, @PathVariable("id") String id) {
        return new ResponseEntity<>(this.adminService.bannedUser(isBanned,id), HttpStatus.OK);
    }


}
