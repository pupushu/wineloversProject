package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.data.repositories.shop.AddressRepository;
import softuni.winelovers.data.repositories.shop.ShopRepository;
import softuni.winelovers.service.models.addresses.CreateAddressModelService;
import softuni.winelovers.service.models.shops.CreateShopModelService;
import softuni.winelovers.service.models.shops.GetShopModelService;
import softuni.winelovers.service.services.AddressService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.web.models.shop.GetShopModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {
    private final ModelMapper modelMapper;
    private final ShopRepository shopRepository;
    private final AddressService addressService;

    @Autowired
    public ShopServiceImpl(ModelMapper modelMapper, ShopRepository shopRepository, AddressService addressService) {
        this.modelMapper = modelMapper;
        this.shopRepository = shopRepository;
        this.addressService = addressService;
    }

    @Override
    public void create(CreateShopModelService sh){
        Shop shop = this.modelMapper.map(sh, Shop.class);
        shop.getAddress().setShop(shop);
        this.shopRepository.save(shop);
    }

    @Override
    public List<GetShopModelService> findAll() {
        return this.shopRepository.findAll()
                .stream()
                .map(shop -> this.modelMapper.map(shop, GetShopModelService.class))
                .collect(Collectors.toList());
    }

    public List<Shop> getSelectedShops(List<String> shops) {
        List<Shop> result = new ArrayList<>();
        for (String shop : shops) {
            Optional<Shop> sh = this.shopRepository.findById(shop);
            Shop getted = sh.get();
            result.add(getted);
        }
        return result;
    }

    @Override
    public GetShopModel findByName(String name) {
        return this.modelMapper.map(this.shopRepository.findByName(name), GetShopModel.class);
    }

    @Override
    public GetShopModelService findById(String id) throws Exception {
            Optional<Shop> shop = this.shopRepository.findById(id);
            if (shop != null){
                return this.modelMapper.map(shop.get(), GetShopModelService.class);
            }else {
                throw new Exception("Shop not found");
        }
    }

    @Override
    public void update(GetShopModelService shopService) {
        Shop shop = this.modelMapper.map(shopService, Shop.class);
        shop.getAddress().setShop(shop);
        this.shopRepository.save(shop);
    }

}
