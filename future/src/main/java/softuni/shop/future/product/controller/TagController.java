package softuni.shop.future.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.shop.future.product.service.api.TagService;

@RestController
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/allGenres")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.tagService.getAllGenres(), HttpStatus.OK);
    }
}
