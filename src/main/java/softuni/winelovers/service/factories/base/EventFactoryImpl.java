package softuni.winelovers.service.factories.base;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import softuni.winelovers.config.annotations.Factory;
import softuni.winelovers.data.models.news.Event;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.service.factories.EventFactory;
import softuni.winelovers.service.models.events.CreateEventModelService;
import softuni.winelovers.service.models.events.CreateEventWithoutAddressModelService;
import softuni.winelovers.web.models.events.CreateEventModel;
import softuni.winelovers.web.models.events.CreateEventWithoutAddressModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Factory
public class EventFactoryImpl implements EventFactory {
    private final ModelMapper modelMapper;

    @Autowired
    public EventFactoryImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateEventModelService create(CreateEventModel model) throws ParseException {
        CreateEventModelService event = this.modelMapper.map(model, CreateEventModelService.class);
        event.setStartDate(StringToDate(model.getStartDate()));
        event.setEndDate(StringToDate(model.getEndDate()));

        return event;
    }

    @Override
    public CreateEventWithoutAddressModelService createWithoutAddress(CreateEventWithoutAddressModel model) throws ParseException {
        CreateEventWithoutAddressModelService event = this.modelMapper.map(model, CreateEventWithoutAddressModelService.class);
        event.setStartDate(StringToDate(model.getStartDate()));
        event.setEndDate(StringToDate(model.getEndDate()));

        return event;
    }

    private Date StringToDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }
}
