package softuni.winelovers.service.models.wines;

import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.data.models.user.User;
import softuni.winelovers.data.models.wine.WineNote;
import softuni.winelovers.data.models.wine.WineType;

import java.math.BigDecimal;
import java.util.List;

public class GetWinesModelService {
    private String id;
    private String name;
    private String producer;
    private String variety;
    private Integer year;
    private String CountryOfOrigin;
    private BigDecimal price;
    private WineType wineType;
    private String picture;
    private WineNote wineNote;
    private List<User> drinkers;
    private List<Shop> whereToBuy;

    public GetWinesModelService() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public WineNote getWineNote() {
        return wineNote;
    }

    public void setWineNote(WineNote wineNote) {
        this.wineNote = wineNote;
    }

    public List<User> getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(List<User> drinkers) {
        this.drinkers = drinkers;
    }

    public List<Shop> getWhereToBuy() {
        return whereToBuy;
    }

    public void setWhereToBuy(List<Shop> whereToBuy) {
        this.whereToBuy = whereToBuy;
    }
}
