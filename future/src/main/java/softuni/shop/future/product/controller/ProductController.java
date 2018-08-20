package softuni.shop.future.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.shop.future.product.service.api.ProductService;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/genreProducts")
    public ResponseEntity<?> addProduct(@RequestBody String genre) {
        return new ResponseEntity<>(this.productService.getProductsByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<?> allProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> productDetails(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.productService.getProductById(id), HttpStatus.OK);
    }


}
