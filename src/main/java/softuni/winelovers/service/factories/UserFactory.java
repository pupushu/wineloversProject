package softuni.winelovers.service.factories;

import softuni.winelovers.data.models.user.User;

public interface UserFactory {
    User create(String username, String email, String password);
}
