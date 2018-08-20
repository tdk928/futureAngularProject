package softuni.shop.future.product.service.impl;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import softuni.shop.future.app.util.DTOConverter;
import softuni.shop.future.product.model.entity.Product;
import softuni.shop.future.product.model.entity.Tag;
import softuni.shop.future.product.model.request.CreateProductModel;
import softuni.shop.future.product.repository.ProductRepository;
import softuni.shop.future.product.repository.TagRepository;
import softuni.shop.future.product.service.api.ProductService;

import java.util.*;
import java.util.stream.Collectors;

import static softuni.shop.future.app.util.AppConstants.SUCCESSFULLY_ADD_PRODUCT;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService {
    private final ProductRepository productRepository;
    private final TagRepository tagRepository;

    public ProductServiceImpl(ProductRepository productRepository, TagRepository tagRepository) {
        this.productRepository = productRepository;

        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseEntity<?> createProduct(CreateProductModel createModel, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(this.processErrors(errors), HttpStatus.BAD_REQUEST);
        }

        this.persistNewProduct(createModel);

        return new ResponseEntity<>(new Gson().toJson(SUCCESSFULLY_ADD_PRODUCT), HttpStatus.CREATED);
    }

    @Override
    public List<Product> getProductsByGenre(String genre) {
        List<Product> result = new ArrayList<>();
        this.productRepository.findAll().forEach(e -> {
            if(e.getTags().stream().filter(p -> p.getName().equals(genre)).collect(Collectors.toList()).size() > 0) {
                result.add(e);
            }
        });
        return result;
    }

    @Override
    public Product getProductById(String id) {
        return  this.productRepository.findFirstById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    private Map<String, String> processErrors(Errors errors) {
        Map<String, String> errorsByField = new HashMap<>();
        for (FieldError current : errors.getFieldErrors())
            errorsByField.put(current.getField(), current.getDefaultMessage());
        return errorsByField;
    }

    private void persistNewProduct(CreateProductModel createModel) {
        Product product = DTOConverter.convert(createModel, Product.class);
        this.fillTags(product,createModel.getTags());
        this.productRepository.save(product);
    }

    private void fillTags(Product product,Set<String> tags) {
        product.clearTags();
        for (String tagName : tags) {
            Tag tag = this.tagRepository.findByName(tagName);
            if(tag != null) {
                product.addTag(tag);
            }
        }
    }
}
