package softuni.winelovers.service.models.wines;

public class GetWineNoteModelService {
    private String id;
    private String tasteNotes;
    private String noseNotes;
    private String color;
    private GetWinesModelService wine;

    public GetWineNoteModelService() {
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

    public GetWinesModelService getWine() {
        return wine;
    }

    public void setWine(GetWinesModelService wine) {
        this.wine = wine;
    }
}
