package softuni.winelovers.web.models.shop;

import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.web.models.addresses.CreateAddressModel;

public class CreateShopModel {
    private String name;
    private CreateAddressModel address;

    public CreateShopModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateAddressModel getAddress() {
        return address;
    }

    public void setAddress(CreateAddressModel address) {
        this.address = address;
    }
}
