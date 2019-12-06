package softuni.winelovers.web.models.wines;

import softuni.winelovers.web.models.users.UserProfileModel;

public class GetWineCommentModel {
    private String id;
    private double nosePoints;
    private double tastePoints;
    private String comment;
    private UserProfileModel user;
    private GetWineModel wine;

    public GetWineCommentModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserProfileModel getUser() {
        return user;
    }

    public void setUser(UserProfileModel user) {
        this.user = user;
    }

    public GetWineModel getWine() {
        return wine;
    }

    public void setWine(GetWineModel wine) {
        this.wine = wine;
    }
}
