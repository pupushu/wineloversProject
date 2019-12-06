package softuni.winelovers.data.models.wine;

import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.user.User;

import javax.persistence.*;

@Entity
@Table(name = "wine_comments")
public class WineComment extends BaseEntity {

    @Column(name = "nose_points")
    private double nosePoints;

    @Column(name = "taste_points")
    private double tastePoints;

    @Lob
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "wine_id")
    private String wineId;

    public WineComment() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWineId() {
        return wineId;
    }

    public void setWineId(String wineId) {
        this.wineId = wineId;
    }
}
