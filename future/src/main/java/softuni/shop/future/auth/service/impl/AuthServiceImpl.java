package softuni.shop.future.auth.service.impl;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import softuni.shop.future.app.model.response.JwtAuthenticationResponseModel;
import softuni.shop.future.app.security.jwt.JwtTokenProvider;
import softuni.shop.future.app.service.BaseService;
import softuni.shop.future.app.util.DTOConverter;
import softuni.shop.future.auth.model.request.SignInRequestModel;
import softuni.shop.future.auth.model.request.SignUpRequestModel;
import softuni.shop.future.auth.service.api.AuthService;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.enumeration.RoleName;
import softuni.shop.future.user.repository.UserRepository;
import softuni.shop.future.user.service.api.RoleService;

import static softuni.shop.future.app.util.AppConstants.*;

@Service
@Transactional
public class AuthServiceImpl extends BaseService implements AuthService {

    private final JwtTokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    private final RoleService roleService;



    public AuthServiceImpl(JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager,
                           UserRepository userRepository, RoleService roleService) {
        super(userRepository);
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
    }

    @Override
    public ResponseEntity<?> signInUser(SignInRequestModel signInRequestModel, Errors errors) {
        if (errors.hasErrors()) return new ResponseEntity(super.processErrors(errors), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestModel.getUsername(),
                        signInRequestModel.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponseModel(jwt, authentication.getName()));
    }

    @Override
    public ResponseEntity<?> signUpUser(SignUpRequestModel signUpRequestModel, Errors errors) {
        if (errors.hasErrors()) return new ResponseEntity(super.processErrors(errors), HttpStatus.BAD_REQUEST);

        ResponseEntity<?> validated = super.validateSignUpData(signUpRequestModel);

        if (validated != null) return validated;

        this.persistNewUser(signUpRequestModel);

        return new ResponseEntity<>(new Gson().toJson(
                String.format(USER_REGISTERED_SUCCESSFULLY_MESSAGE, signUpRequestModel.getUsername())
        ), HttpStatus.CREATED);
    }

    private void persistNewUser(SignUpRequestModel signUpRequestModel) {
        User user = DTOConverter.convert(signUpRequestModel, User.class);
        user.addRole(this.roleService.findByName(RoleName.ROLE_USER).get());
        super.userRepository.save(user);
    }

}
