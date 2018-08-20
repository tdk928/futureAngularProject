package softuni.shop.future.user.service.api;

import softuni.shop.future.user.model.entity.Role;
import softuni.shop.future.user.model.enumeration.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName roleUser);
}
