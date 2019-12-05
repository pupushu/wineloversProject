package softuni.winelovers.service.models.addresses;

public class CreateAddressModelService {
    private String country;
    private String city;
    private String street;
    private String streetNumber;

    public CreateAddressModelService() {
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
        return streetNumber;
    }

    public void setNumber(String number) {
        this.streetNumber = number;
    }
}
