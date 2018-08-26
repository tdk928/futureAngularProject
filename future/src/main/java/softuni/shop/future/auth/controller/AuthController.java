package softuni.shop.future.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import softuni.shop.future.auth.model.request.SignInRequestModel;
import softuni.shop.future.auth.model.request.SignUpRequestModel;
import softuni.shop.future.auth.service.api.AuthService;
import softuni.shop.future.user.service.api.UserService;

import javax.validation.Valid;

import java.security.Principal;

import static softuni.shop.future.app.util.AppConstants.*;

@RestController
@RequestMapping(AUTH_URL)
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping(SIGNUP_URL)
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequestModel signUpRequestModel, Errors errors) {
        return this.authService.signUpUser(signUpRequestModel, errors);
    }

    @PostMapping(SIGNIN_URL)
    public ResponseEntity<?> signInUser(@Valid @RequestBody SignInRequestModel signInRequestModel, Errors errors) {
        return this.authService.signInUser(signInRequestModel, errors);
    }

    @GetMapping("/checkIsAdmin")
    public ResponseEntity<?> checkIsAdmin(Principal principal) {
        boolean b = this.authService.checkForAdmin(principal);
        return new ResponseEntity<>(this.authService.checkForAdmin(principal), HttpStatus.OK);
    }

}
