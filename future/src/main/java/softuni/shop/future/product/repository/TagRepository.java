package softuni.shop.future.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.shop.future.product.model.entity.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
