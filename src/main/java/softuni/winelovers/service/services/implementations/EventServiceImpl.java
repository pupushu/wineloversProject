package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.news.Event;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.data.repositories.news.EventRepository;
import softuni.winelovers.data.repositories.shop.AddressRepository;
import softuni.winelovers.service.factories.EventFactory;
import softuni.winelovers.service.models.events.CreateEventModelService;
import softuni.winelovers.service.models.events.CreateEventWithoutAddressModelService;
import softuni.winelovers.service.models.events.GetEventModelService;
import softuni.winelovers.service.services.EventService;
import softuni.winelovers.web.models.events.CreateEventModel;
import softuni.winelovers.web.models.events.CreateEventWithoutAddressModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventFactory eventFactory;
    private final AddressRepository addressRepository;

    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper, EventFactory eventFactory, AddressRepository addressRepository) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.eventFactory = eventFactory;
        this.addressRepository = addressRepository;
    }

    @Override
    public void createEvent(CreateEventModel event) throws ParseException {
        CreateEventModelService eventToAdd = eventFactory.create(event);
        this.eventRepository.save(this.modelMapper.map(eventToAdd, Event.class));
    }

    @Override
    public List<CreateEventModelService> findAll() {
        return this.addressRepository.findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, CreateEventModelService.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createEventWithoutAddress(CreateEventWithoutAddressModel event) throws ParseException {
        CreateEventWithoutAddressModelService model = this.eventFactory.createWithoutAddress(event);
        Event eventToSave = this.modelMapper.map(model, Event.class);
        eventToSave.getAddress().forEach(ad -> ad.addEvent(eventToSave));
        List<Address> addresses = eventToSave.getAddress();
        eventToSave.setAddress(null);
        Event event1 = this.eventRepository.save(eventToSave);
        event1.setAddress(addresses);
        this.eventRepository.save(event1);
    }

    @Override
    public List<GetEventModelService> getAllEvents() {
        return this.eventRepository.findAll().stream()
                .map(e -> this.modelMapper.map(e, GetEventModelService.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetEventModelService findById(String id) throws Exception {
        Optional<Event> event = this.eventRepository.findById(id);
        if (event.isPresent()){
            return this.modelMapper.map(event.get(), GetEventModelService.class);
        }else {
            throw new Exception("Event not found");
        }
    }
}
