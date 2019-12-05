package softuni.winelovers.service.services;

import softuni.winelovers.data.models.wine.Wine;
import softuni.winelovers.service.models.wines.CreateWineModelService;
import softuni.winelovers.service.models.wines.GetWineNoteModelService;
import softuni.winelovers.service.models.wines.GetWinesModelService;

import java.util.List;
import java.util.Optional;

public interface WineService {
    void createWine(CreateWineModelService wine, List<String> shops);

    List<GetWinesModelService> getAll();

    GetWinesModelService findById(String id) throws Exception;

    void update(GetWinesModelService wine);
}
