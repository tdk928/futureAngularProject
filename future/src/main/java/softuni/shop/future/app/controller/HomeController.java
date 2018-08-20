package softuni.shop.future.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static softuni.shop.future.app.util.AppConstants.HOME_URL;

@RestController
public class HomeController {
    @GetMapping(HOME_URL)
    public ResponseEntity<?> home() {
        String welcomeMsg = "home msg";
        return new ResponseEntity<>(welcomeMsg, HttpStatus.OK);
    }
}
