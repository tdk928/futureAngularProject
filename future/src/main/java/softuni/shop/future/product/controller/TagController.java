package softuni.shop.future.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import softuni.shop.future.product.service.api.TagService;

@RestController
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/product/allGenres")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.tagService.getAllGenres(), HttpStatus.OK);
    }

    @GetMapping("/product/tags/{id}")
    public ResponseEntity<?> getTagsForCurrentProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.tagService.getAllTagsForProduct(id), HttpStatus.OK);
    }

    @GetMapping("/product/colors/{id}")
    public ResponseEntity<?> getColorsForCurrentProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.tagService.getAllColorsForProduct(id), HttpStatus.OK);
    }
}
