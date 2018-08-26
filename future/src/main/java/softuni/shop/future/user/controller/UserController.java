package softuni.shop.future.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.shop.future.user.model.request.BuyProductsBindingModel;
import softuni.shop.future.user.model.request.BuyProductsDto;
import softuni.shop.future.user.service.api.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/user/buyProducts")
//    public ResponseEntity<?> addProduct(@Valid @RequestBody BuyProductsDto model, Principal principal) {
//        return new ResponseEntity<>(this.userService.buyProducts(model,principal), HttpStatus.OK);
//    }

    @PostMapping("/user/buyProducts")
    public ResponseEntity<?> addProduct(@Valid @RequestBody String model, Principal principal) {
        return new ResponseEntity<>(this.userService.buyProducts(model,principal), HttpStatus.OK);
    }

}
