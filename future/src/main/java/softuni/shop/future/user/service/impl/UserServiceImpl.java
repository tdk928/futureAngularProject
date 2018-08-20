package softuni.shop.future.user.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.shop.future.app.service.IService;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements softuni.shop.future.user.service.api.UserService, IService<User> {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
