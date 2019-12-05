package softuni.winelovers.service.services;

import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.service.models.events.CreateEventModelService;
import softuni.winelovers.service.models.events.GetEventModelService;
import softuni.winelovers.web.models.events.CreateEventModel;
import softuni.winelovers.web.models.events.CreateEventWithoutAddressModel;

import java.text.ParseException;
import java.util.List;

public interface EventService {
    void createEvent(CreateEventModel event) throws ParseException;

    List<CreateEventModelService> findAll();

    void createEventWithoutAddress(CreateEventWithoutAddressModel event) throws ParseException;

    List<GetEventModelService> getAllEvents();

    GetEventModelService findById(String id) throws Exception;

    void updateEvent(GetEventModelService event) throws Exception;
}
