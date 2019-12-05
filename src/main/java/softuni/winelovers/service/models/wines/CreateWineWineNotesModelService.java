package softuni.winelovers.service.models.wines;

import softuni.winelovers.data.models.user.User;

public class CreateWineWineNotesModelService {
    private String color;
    private String nose;
    private String taste;

    public CreateWineWineNotesModelService() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
