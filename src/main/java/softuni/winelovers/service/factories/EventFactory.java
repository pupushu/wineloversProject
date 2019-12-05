package softuni.winelovers.service.factories;

import softuni.winelovers.data.models.news.Event;
import softuni.winelovers.service.models.events.CreateEventModelService;
import softuni.winelovers.service.models.events.CreateEventWithoutAddressModelService;
import softuni.winelovers.web.models.events.CreateEventModel;
import softuni.winelovers.web.models.events.CreateEventWithoutAddressModel;

import java.text.ParseException;

public interface EventFactory {
    CreateEventModelService create(CreateEventModel model) throws ParseException;

    CreateEventWithoutAddressModelService createWithoutAddress(CreateEventWithoutAddressModel model) throws ParseException;
}
