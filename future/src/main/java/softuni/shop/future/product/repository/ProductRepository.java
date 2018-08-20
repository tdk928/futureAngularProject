package softuni.shop.future.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.shop.future.product.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findFirstById(String id);
}
