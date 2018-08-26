package softuni.shop.future.product.service.api;

import java.util.List;

public interface TagService {
    List<String> getAllGenres();

    List<String> getAllTagsForProduct(String id);

    List<String> getAllColorsForProduct(String id);
}
