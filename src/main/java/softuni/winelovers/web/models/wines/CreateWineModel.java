package softuni.winelovers.web.models.wines;

import softuni.winelovers.data.models.wine.WineType;

import java.math.BigDecimal;

public class CreateWineModel {
    private String name;
    private String producer;
    private String variety;
    private Integer year;
    private String CountryOfOrigin;
    private BigDecimal price;
    private WineType wineType;
    private String picture;
    private CreateWineWineNotesModel wineNotes;


    public CreateWineModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountryOfOrigin() {
        return CountryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        CountryOfOrigin = countryOfOrigin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WineType getWineType() {
        return wineType;
    }

    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CreateWineWineNotesModel getWineNotes() {
        return wineNotes;
    }

    public void setWineNotes(CreateWineWineNotesModel wineNotes) {
        this.wineNotes = wineNotes;
    }
}
