package softuni.shop.future.product.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.shop.future.product.model.entity.Product;

import softuni.shop.future.product.repository.ProductRepository;
import softuni.shop.future.product.repository.TagRepository;
import softuni.shop.future.product.service.api.ProductService;

import java.util.*;
import java.util.stream.Collectors;


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
    public List<Product> getLastThreeProducts() {
        return  this.productRepository.getLastThreeProducts();
    }

    @Override
    public Product getProductById(String id) {
        return  this.productRepository.findFirstById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

}
