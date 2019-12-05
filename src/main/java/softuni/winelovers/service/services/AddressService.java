package softuni.winelovers.service.services;

import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.service.models.addresses.CreateAddressModelService;
import softuni.winelovers.service.models.addresses.GetAddressModelService;
import softuni.winelovers.web.models.addresses.CreateAddressModel;

import java.util.List;

public interface AddressService {

    boolean createAddressIfNotPresent(CreateAddressModelService add);

    CreateAddressModelService findById(String id) throws Exception;

    List<GetAddressModelService> findAll();
}
