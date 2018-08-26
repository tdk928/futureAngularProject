package softuni.shop.future.auth.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import softuni.shop.future.auth.model.request.SignInRequestModel;
import softuni.shop.future.auth.model.request.SignUpRequestModel;
import softuni.shop.future.user.model.request.CurrentUserDto;

import java.security.Principal;

public interface AuthService {


    boolean checkForAdmin(Principal principal);

    ResponseEntity<?> signUpUser(SignUpRequestModel signUpRequestModel, Errors errors);

    ResponseEntity<?> signInUser(SignInRequestModel signInRequestModel, Errors errors);

    CurrentUserDto getCurrentUser(Principal principal);
}
