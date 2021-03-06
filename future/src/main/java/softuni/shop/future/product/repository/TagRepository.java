package softuni.shop.future.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.shop.future.product.model.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
