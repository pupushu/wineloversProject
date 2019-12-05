package softuni.winelovers.data.models.shop;

import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.news.Event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @ManyToMany(mappedBy = "eventAddress")
    private List<Event> events;

    // i tuk li e sashtia mapping??? Tova e dosta stranno
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Shop shop;

    public Address() {
        this.events = new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addEvent(Event event){
        this.events.add(event);
    }
    //    TODO: google map locator
}
