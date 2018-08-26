package softuni.shop.future.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.shop.future.product.service.api.ColorService;

@RestController
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/product/colors/all")
    public ResponseEntity<?> getAllColors() {
        return new ResponseEntity<>(this.colorService.getAllColors(), HttpStatus.OK);
    }
}
