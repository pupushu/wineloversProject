package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.data.repositories.shop.AddressRepository;
import softuni.winelovers.service.models.addresses.CreateAddressModelService;
import softuni.winelovers.service.models.addresses.GetAddressModelService;
import softuni.winelovers.service.models.events.GetEventModelService;
import softuni.winelovers.service.services.AddressService;
import softuni.winelovers.web.models.addresses.GetAddressModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(ModelMapper modelMapper, AddressRepository addressRepository) {
        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public boolean createAddressIfNotPresent(CreateAddressModelService add) {
        Address address = this.modelMapper.map(add, Address.class);
        if (!dataContainAddress(address)) {
            this.create(address);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public CreateAddressModelService findById(String id) throws Exception {
        Optional<Address> result = this.addressRepository.findById(id);
        if (!result.isEmpty()) {
            return this.modelMapper.map(result.get(), CreateAddressModelService.class);
        } else {
            throw new Exception("Invalid address");
        }
    }

    @Override
    public List<GetAddressModelService> findAll() {
        return this.addressRepository.findAll().stream()
                .map(a -> this.modelMapper.map(a, GetAddressModelService.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetAddressModelService getAddressWithId(String id) {
        return this.modelMapper.map(this.addressRepository.findById(id).get(), GetAddressModelService.class);
    }

    private boolean dataContainAddress(Address address) {
        Optional<Address> addr = this.addressRepository
                .findByCountryAndCityAndStreetAndNumber(address.getCountry(), address.getCity(), address.getStreet(), address.getNumber());
        return !addr.isEmpty();
    }


    public void create(Address address) {
        this.addressRepository.save(address);
    }


}
