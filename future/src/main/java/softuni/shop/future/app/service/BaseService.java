package softuni.shop.future.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import softuni.shop.future.app.model.response.HttpErrorResponseModel;
import softuni.shop.future.auth.model.request.SignUpRequestModel;
import softuni.shop.future.user.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

import static softuni.shop.future.app.util.AppConstants.*;

public abstract class BaseService<T> {

    protected final UserRepository userRepository;

    protected BaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected ResponseEntity<?> validateSignUpData(SignUpRequestModel signUpRequestModel) {
        if (userRepository.existsByUsername(signUpRequestModel.getUsername()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.CONFLICT.value(), USERNAME_IS_ALREADY_TAKEN_MESSAGE),
                    HttpStatus.CONFLICT);

        if (userRepository.existsByEmail(signUpRequestModel.getEmail()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.CONFLICT.value(), EMAIL_ADDRESS_ALREADY_IN_USE_MESSAGE),
                    HttpStatus.CONFLICT);

        if (!signUpRequestModel.getPassword().equals(signUpRequestModel.getConfirm()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.BAD_REQUEST.value(), PASSWORDS_MISMATCH_MESSAGE),
                    HttpStatus.BAD_REQUEST);

        return null;
    }

    protected Map<String, String> processErrors(Errors errors) {
        Map<String, String> errorsByField = new HashMap<>();
        for (FieldError current : errors.getFieldErrors())
            errorsByField.put(current.getField(), current.getDefaultMessage());
        return errorsByField;
    }
}
