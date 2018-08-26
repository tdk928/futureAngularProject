package softuni.shop.future.user.service.api;

import org.springframework.http.ResponseEntity;
import softuni.shop.future.app.service.IService;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.request.AllUsersDTO;
import softuni.shop.future.user.model.request.BuyProductsBindingModel;
import softuni.shop.future.user.model.request.BuyProductsDto;

import java.security.Principal;
import java.util.List;

public interface UserService extends IService<User> {
//    ResponseEntity<?> buyProducts(BuyProductsBindingModel model, Principal principal);

//    ResponseEntity<?> buyProducts(BuyProductsDto model, Principal principal);

    ResponseEntity<?> buyProducts(String model, Principal principal);


    /*boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

    UserProfileDto getUserProfile(String username);

    Optional<User> findById(Long createdBy);

    User getOne(Long id);

    List<User> findByIdIn(List<Long> creatorIds);

    boolean deleteUser(Long username);*/
}
