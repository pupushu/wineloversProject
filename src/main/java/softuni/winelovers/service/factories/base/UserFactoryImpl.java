package softuni.winelovers.service.factories.base;

import org.springframework.beans.factory.annotation.Autowired;
import softuni.winelovers.config.annotations.Factory;
import softuni.winelovers.data.models.user.User;
import softuni.winelovers.data.models.user.UserRole;
import softuni.winelovers.service.factories.UserFactory;
import softuni.winelovers.service.services.HashingService;

import java.util.Date;
import java.util.UUID;

@Factory
public class UserFactoryImpl implements UserFactory {
    private final HashingService hashingService;

    @Autowired
    public UserFactoryImpl(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    @Override
    public User create(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(this.hashingService.hash(password));
        user.setRole(UserRole.valueOf("USER"));
        user.setMailConfirmed(false);
        user.setDateRegistered(new Date());
        user.setMailConfirmationCode(UUID.randomUUID().toString());
        return user;
    }
}
