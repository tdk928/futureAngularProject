package softuni.shop.future.product.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.shop.future.product.model.entity.Color;
import softuni.shop.future.product.repository.ColorRepository;
import softuni.shop.future.product.service.api.ColorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<String> getAllColors() {
        return  this.colorRepository.findAll().stream().map(Color::getName).collect(Collectors.toList());
    }
}
