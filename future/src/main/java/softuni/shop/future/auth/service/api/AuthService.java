package softuni.shop.future.auth.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import softuni.shop.future.auth.model.request.SignInRequestModel;
import softuni.shop.future.auth.model.request.SignUpRequestModel;

public interface AuthService {
    ResponseEntity<?> signUpUser(SignUpRequestModel signUpRequestModel, Errors errors);

    ResponseEntity<?> signInUser(SignInRequestModel signInRequestModel, Errors errors);
}
