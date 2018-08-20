package softuni.shop.future.product.service.impl;

import org.springframework.stereotype.Service;
import softuni.shop.future.product.model.entity.Tag;
import softuni.shop.future.product.repository.TagRepository;
import softuni.shop.future.product.service.api.TagService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<String> getAllGenres () {
        return this.tagRepository.findAll().stream().map(Tag::getName).collect(Collectors.toList());
    }
}
