package softuni.winelovers.service.services;

import softuni.winelovers.service.models.wines.CreateWineModelService;
import softuni.winelovers.service.models.wines.GetWineModelService;

import java.util.List;

public interface WineService {
    void createWine(CreateWineModelService wine, List<String> shops);

    List<GetWineModelService> getAll();

    GetWineModelService findById(String id) throws Exception;

    void update(GetWineModelService wine);
}
