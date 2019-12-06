package softuni.winelovers.service.models.user;

import softuni.winelovers.service.models.wines.GetWineModelService;

import java.util.Date;
import java.util.List;

public class UserProfileModelService {
    private String username;
    private Date dateRegistered;
    private String email;
    private List<GetWineModelService> wines;


    public UserProfileModelService() {
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

    public List<GetWineModelService> getWines() {
        return wines;
    }

    public void setWines(List<GetWineModelService> wines) {
        this.wines = wines;
    }
}
