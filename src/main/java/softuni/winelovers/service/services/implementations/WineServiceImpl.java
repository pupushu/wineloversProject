package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.data.models.wine.Wine;
import softuni.winelovers.data.models.wine.WineNote;
import softuni.winelovers.data.repositories.wine.WineRepository;
import softuni.winelovers.service.models.wines.CreateWineModelService;
import softuni.winelovers.service.models.wines.GetWineNoteModelService;
import softuni.winelovers.service.models.wines.GetWinesModelService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.service.services.WineService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WineServiceImpl implements WineService {
    private final ModelMapper modelMapper;
    private final WineRepository wineRepository;
    private final ShopService shopService;

    @Autowired
    public WineServiceImpl(ModelMapper modelMapper, WineRepository wineRepository, ShopService shopService) {
        this.modelMapper = modelMapper;
        this.wineRepository = wineRepository;
        this.shopService = shopService;
    }

    @Override
    public void createWine(CreateWineModelService wine, List<String> shops) {
        List<Shop> selectedShops = this.shopService.getSelectedShops(shops);
        WineNote wineNote = this.modelMapper.map(wine.getWineNotes(), WineNote.class);
        Wine wineToAdd = this.modelMapper.map(wine, Wine.class);
        wineToAdd.setWineNote(wineNote);
        wineToAdd.setWhereToBuy(selectedShops);
        this.wineRepository.save(wineToAdd);
    }

    @Override
    public List<GetWinesModelService> getAll() {
        return this.wineRepository.findAll().stream()
                .map(wine -> this.modelMapper.map(wine, GetWinesModelService.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetWinesModelService findById(String id) throws Exception {
        Optional<Wine> wine = this.wineRepository.findById(id);
        if (wine.isPresent()){
            return this.modelMapper.map(wine.get(), GetWinesModelService.class);
        }else {
            throw new Exception("Invalid wine");
        }

    }

    @Override
    public void update(GetWinesModelService wine) {
        Wine wineToAdd = this.modelMapper.map(wine, Wine.class);
        wineToAdd.setWhereToBuy(null);
        List<Shop> shopList = wine.getWhereToBuy().stream()
                .map(shop -> this.modelMapper.map(shop, Shop.class))
                .collect(Collectors.toList());
        this.wineRepository.save(wineToAdd);
        shopList.forEach(shop -> {
            shop.addWine(wineToAdd);
            shop.getAddress().setShop(shop);
        });
        wineToAdd.setWhereToBuy(shopList);
        this.wineRepository.save(wineToAdd);

    }


}
