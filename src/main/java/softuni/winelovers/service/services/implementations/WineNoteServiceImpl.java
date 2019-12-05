package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.wine.WineNote;
import softuni.winelovers.data.repositories.wine.WineNoteRepository;
import softuni.winelovers.service.services.WineNoteService;

@Service
public class WineNoteServiceImpl implements WineNoteService {
    private final ModelMapper modelMapper;
    private final WineNoteRepository wineNoteRepository;

    @Autowired
    public WineNoteServiceImpl(ModelMapper modelMapper, WineNoteRepository wineNoteRepository) {
        this.modelMapper = modelMapper;
        this.wineNoteRepository = wineNoteRepository;
    }

    @Override
    public void update(WineNote wineNote) {
        this.wineNoteRepository.save(wineNote);
    }
}
