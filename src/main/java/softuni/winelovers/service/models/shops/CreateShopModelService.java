package softuni.winelovers.service.models.shops;

import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.service.models.addresses.CreateAddressModelService;

public class CreateShopModelService {
    private String name;
    private CreateAddressModelService address;

    public CreateShopModelService() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateAddressModelService getAddress() {
        return address;
    }

    public void setAddress(CreateAddressModelService address) {
        this.address = address;
    }
}
