package softuni.winelovers.service.models.wines;

import softuni.winelovers.service.models.user.UserProfileModelService;

public class CreateWineCommentModelService {
    private double nosePoints;
    private double tastePoints;
    private String comment;
    private UserProfileModelService user;
    private GetWineModelService wine;

    public CreateWineCommentModelService() {
    }

    public double getNosePoints() {
        return nosePoints;
    }

    public void setNosePoints(double nosePoints) {
        this.nosePoints = nosePoints;
    }

    public double getTastePoints() {
        return tastePoints;
    }

    public void setTastePoints(double tastePoints) {
        this.tastePoints = tastePoints;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserProfileModelService getUser() {
        return user;
    }

    public void setUser(UserProfileModelService user) {
        this.user = user;
    }

    public GetWineModelService getWine() {
        return wine;
    }

    public void setWine(GetWineModelService wine) {
        this.wine = wine;
    }
}
