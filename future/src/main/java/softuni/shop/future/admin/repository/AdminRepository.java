package softuni.shop.future.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.shop.future.user.model.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User,String> {
    User findFirstById(Long id);
}
