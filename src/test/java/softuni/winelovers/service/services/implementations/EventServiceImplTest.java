package softuni.winelovers.service.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softuni.winelovers.data.models.news.Event;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.data.repositories.news.EventRepository;
import softuni.winelovers.data.repositories.shop.AddressRepository;
import softuni.winelovers.service.factories.EventFactory;
import softuni.winelovers.web.models.events.CreateEventModel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceImplTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private AddressRepository addressRepository;

    EventServiceImpl serviceUnderTest;
    private Address addresToUse;

    @BeforeEach
    void setup() {
//        serviceUnderTest = new EventServiceImpl(eventRepository, modelMapper, eventFactory, addressRepository);
//
//        Address address = new Address();
//        address.setId("TEST_ID");
//        address.setCity("CITY");
//        address.setCountry("COUNTRY");
//        address.setStreet("STREET");
//        address.setNumber("NUMBER");
//
//        addresToUse = addressRepository.save(address);

    }


    @Test
    public void testCreateEventWithAddress() {

        Address address = new Address();
        address.setId("TEST_ID");
        address.setCity("CITY");
        address.setCountry("COUNTRY");
        address.setStreet("STREET");
        address.setNumber("NUMBER");

        Event event = new Event();
        //event.setId("EVENT_ID");
        event.setTitle("TITLE");
        event.setStartDate(new Date());
        event.setEndDate(new Date());
        event.setPrice(new BigDecimal(29));
        event.setContent("CONTENT");
        //event.setAddress(Arrays.asList(address));
        address.setEvents(Arrays.asList(event));
        Event event1 = eventRepository.save(event);

        event1.setAddress(Arrays.asList(address));
        eventRepository.save(event1);


    }



}