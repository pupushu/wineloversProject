package softuni.winelovers.data.models.wine;

import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wine_notes")
public class WineNote extends BaseEntity {
    @Lob
    @Column(name = "taste_notes", columnDefinition = "TEXT")
    private String tasteNotes;

    @Lob
    @Column(name = "nose_notes", columnDefinition = "TEXT")
    private String noseNotes;

    @Lob
    @Column(name = "color", columnDefinition = "TEXT")
    private String color;

    @OneToOne(mappedBy = "wineNote")
    private Wine wine;

    public WineNote() {
    }

    public String getTasteNotes() {
        return tasteNotes;
    }

    public void setTasteNotes(String tasteNotes) {
        this.tasteNotes = tasteNotes;
    }

    public String getNoseNotes() {
        return noseNotes;
    }

    public void setNoseNotes(String noseNotes) {
        this.noseNotes = noseNotes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

}
