package softuni.winelovers.service.models.shops;

import softuni.winelovers.service.models.addresses.CreateAddressModelService;
import softuni.winelovers.service.models.addresses.GetAddressModelService;

public class GetShopModelService {
    private String id;
    private String name;
    private GetAddressModelService address;

    public GetShopModelService() {
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

    public GetAddressModelService getAddress() {
        return address;
    }

    public void setAddress(GetAddressModelService address) {
        this.address = address;
    }
}
