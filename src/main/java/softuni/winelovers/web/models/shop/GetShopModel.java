package softuni.winelovers.web.models.shop;

import softuni.winelovers.web.models.addresses.GetAddressModel;

public class GetShopModel {
    private String id;
    private String name;
    private GetAddressModel address;

    public GetShopModel() {
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

    public GetAddressModel getAddress() {
        return address;
    }

    public void setAddress(GetAddressModel address) {
        this.address = address;
    }
}
