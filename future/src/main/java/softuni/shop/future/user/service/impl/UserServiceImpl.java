package softuni.shop.future.user.service.impl;


import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.shop.future.product.model.entity.Product;
import softuni.shop.future.product.repository.ProductRepository;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.request.BuyProductsBindingModel;
import softuni.shop.future.user.repository.UserRepository;
import softuni.shop.future.user.service.api.UserService;

import java.security.Principal;
import java.util.List;

import static softuni.shop.future.app.util.AppConstants.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> buyProducts(String model, Principal principal) {
        BuyProductsBindingModel[] dto = new Gson().fromJson(model,BuyProductsBindingModel[].class);
        User user = this.userRepository.findFirstByUsername(principal.getName());
        for (BuyProductsBindingModel product : dto) {
            Product p = this.productRepository.findFirstById(product.getId());
            if(p == null) {
                return new ResponseEntity<>(new Gson().toJson(
                        "product not found"), HttpStatus.BAD_REQUEST);
            }
            for (int i = 0; i < Integer.parseInt(product.getQuantity()); i++) {
                user.buyProduct(p);
                this.userRepository.save(user);
            }


        }


        return new ResponseEntity<>(new Gson().toJson(
                USER_SUCCESSFULLY_BUYING_PRODUCTS_MESSAGE), HttpStatus.CREATED);
    }

//    public <T> T importJson(Class<T> tClass, String model)
//            throws IOException {
//
//        T mapped = new Gson().fromJson(model, tClass);
//        return mapped;
//    }

}
