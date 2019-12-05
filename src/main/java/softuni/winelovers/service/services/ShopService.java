package softuni.winelovers.service.services;

import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.service.models.shops.CreateShopModelService;
import softuni.winelovers.service.models.shops.GetShopModelService;
import softuni.winelovers.web.models.shop.GetShopModel;

import java.util.List;

public interface ShopService {
    void create(CreateShopModelService shop) throws Exception;

    List<GetShopModelService> findAll();

    List<Shop> getSelectedShops(List<String> shops);

    GetShopModel findByName(String name);

    GetShopModelService findById(String id) throws Exception;

    void update(GetShopModelService shopService);
}
