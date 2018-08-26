package softuni.shop.future.product.service.impl;

import org.springframework.stereotype.Service;
import softuni.shop.future.product.model.entity.Color;
import softuni.shop.future.product.model.entity.Tag;
import softuni.shop.future.product.repository.ProductRepository;
import softuni.shop.future.product.repository.TagRepository;
import softuni.shop.future.product.service.api.TagService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ProductRepository productRepository;

    public TagServiceImpl(TagRepository tagRepository, ProductRepository productRepository) {
        this.tagRepository = tagRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<String> getAllGenres () {
        return this.tagRepository.findAll().stream().map(Tag::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTagsForProduct(String id) {
        return this.productRepository.findFirstById(id).getTags().stream().map(Tag::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllColorsForProduct(String id) {
        return this.productRepository.findFirstById(id).getColors().stream().map(Color::getName).collect(Collectors.toList());
    }


}
