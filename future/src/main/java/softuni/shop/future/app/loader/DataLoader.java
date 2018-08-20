package softuni.shop.future.app.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import softuni.shop.future.product.model.entity.Tag;
import softuni.shop.future.product.repository.TagRepository;
import softuni.shop.future.user.model.entity.Role;
import softuni.shop.future.user.model.entity.User;
import softuni.shop.future.user.model.enumeration.RoleName;
import softuni.shop.future.user.repository.RoleRepository;
import softuni.shop.future.user.repository.UserRepository;

import java.util.Set;



@Component
public class DataLoader implements ApplicationRunner {

    private static final String ADMIN_EMAIL = "admin@abv.bg";
    private static final String ADMIN = "admin";
    private static final String ADMIN_PASS = "adminadmin";

    private static final String USER_EMAIL = "user@abv.bg";
    private static final String USER = "user";
    private static final String USER_PASS = "useruser";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TagRepository tagRepository;


    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if(this.userRepository.count() == 0) this.seedUsers();
        if(this.tagRepository.count() == 0 ) this.seedTags();
    }

    private void seedUsers() {
        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);

        this.roleRepository.save(roleUser);
        this.roleRepository.save(roleAdmin);

        User admin = new User(ADMIN, ADMIN_EMAIL, ADMIN_PASS);
        admin.setRoles(Set.of(roleUser, roleAdmin));
        this.userRepository.save(admin);

        User user = new User(USER, USER_EMAIL, USER_PASS);
        user.setRoles(Set.of(roleUser));
        this.userRepository.save(user);
    }

    private void seedTags() {
        Tag male = new Tag("male");
        this.tagRepository.save(male);
        Tag female = new Tag("female");
        this.tagRepository.save(female);
        Tag unisex = new Tag("unisex");
        this.tagRepository.save(unisex);
    }
}
