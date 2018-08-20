package softuni.shop.future.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.shop.future.user.model.entity.Role;
import softuni.shop.future.user.model.enumeration.RoleName;
import softuni.shop.future.user.repository.RoleRepository;

import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements softuni.shop.future.user.service.api.RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(RoleName roleUser) {
        return this.roleRepository.findByName(RoleName.ROLE_USER);
    }
}
