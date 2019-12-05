package softuni.winelovers.service.models.user;

import softuni.winelovers.data.models.wine.WineNote;

import java.util.Date;
import java.util.List;

public class UserProfileServiceModel {
    private String username;
    private Date dateRegistered;
    private String email;

    public UserProfileServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
