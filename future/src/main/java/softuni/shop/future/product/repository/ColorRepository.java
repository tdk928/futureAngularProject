package softuni.shop.future.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.shop.future.product.model.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
}
