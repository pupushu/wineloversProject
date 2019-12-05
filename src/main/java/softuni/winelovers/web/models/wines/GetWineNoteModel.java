package softuni.winelovers.web.models.wines;

public class GetWineNoteModel {
    private String id;
    private String tasteNotes;
    private String noseNotes;
    private String color;
    private GetWineModel wine;


    public GetWineNoteModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public GetWineModel getWine() {
        return wine;
    }

    public void setWine(GetWineModel wine) {
        this.wine = wine;
    }
}
