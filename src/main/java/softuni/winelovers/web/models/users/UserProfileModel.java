package softuni.winelovers.web.models.users;

import softuni.winelovers.data.models.wine.WineNote;
import softuni.winelovers.web.models.wines.GetWineModel;

import java.util.Date;
import java.util.List;

public class UserProfileModel {
    private String username;
    private Date dateRegistered;
    private String email;
    private List<GetWineModel> wines;

    public UserProfileModel() {
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

    public List<GetWineModel> getWines() {
        return wines;
    }

    public void setWines(List<GetWineModel> wines) {
        this.wines = wines;
    }
}
