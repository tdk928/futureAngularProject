package softuni.shop.future.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.shop.future.product.model.entity.Product;
import softuni.shop.future.user.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIdIn(List<Long> userIds);

    User findFirstById(Long id);

    Optional<User> findByUsername(String username);

    User findFirstByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
