package softuni.winelovers.data.models.wine;

import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.data.models.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "wines")
public class Wine extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "variety")
    private String variety;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "country_of_origin", nullable = false)
    private String CountryOfOrigin;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "wine_type")
    @Enumerated(value = EnumType.STRING)
    private WineType wineType;

    @Lob
    @Column(name = "picture", columnDefinition = "TEXT")
    private String picture;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wine_wine_note")
    private WineNote wineNote;

    @ManyToMany(mappedBy = "wines")
    private List<User> drinkers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "shop_wines",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<Shop> whereToBuy;

    public Wine() {
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

    public List<Shop> getWhereToBuy() {
        return whereToBuy;
    }

    public void setWhereToBuy(List<Shop> whereToBuy) {
        this.whereToBuy = whereToBuy;
    }

    public List<User> getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(List<User> drinkers) {
        this.drinkers = drinkers;
    }
}
