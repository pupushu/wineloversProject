package softuni.winelovers.service.models.user;

import softuni.winelovers.data.models.user.UserRole;

public class UserLoginModelService {
    private String username;
    private String password;
    private UserRole role;

    public UserLoginModelService() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
