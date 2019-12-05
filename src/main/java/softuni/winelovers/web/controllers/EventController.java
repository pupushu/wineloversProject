package softuni.winelovers.web.controllers;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.service.models.addresses.GetAddressModelService;
import softuni.winelovers.service.models.events.GetEventModelService;
import softuni.winelovers.service.services.AddressService;
import softuni.winelovers.service.services.EventService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.web.models.addresses.CreateAddressModel;
import softuni.winelovers.web.models.addresses.GetAddressModel;
import softuni.winelovers.web.models.events.CreateEventModel;
import softuni.winelovers.web.models.events.CreateEventWithoutAddressModel;
import softuni.winelovers.web.models.events.GetEventModel;
import softuni.winelovers.web.models.events.UpdateEventModel;
import softuni.winelovers.web.models.shop.GetShopModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {
    private final ModelMapper modelMapper;
    private final EventService eventService;
    private final ShopService shopService;
    private final AddressService addressService;

    @Autowired
    public EventController(ModelMapper modelMapper, EventService eventService, ShopService shopService, AddressService addressService) {
        this.modelMapper = modelMapper;
        this.eventService = eventService;
        this.shopService = shopService;
        this.addressService = addressService;
    }

    @GetMapping("/create-event")
    public String getCreateEvent(Model model) {
        List<GetShopModel> shops = this.shopService.findAll()
                .stream()
                .map(shop -> this.modelMapper.map(shop, GetShopModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allShops", shops);
        return "events/create-event";
    }

    @PostMapping("/create-event")
    public String createEvent(@ModelAttribute CreateEventModel eventModel,
                              @ModelAttribute CreateAddressModel addressModel,
                              @RequestParam(value = "shopCheckbox", required = false) List<String> address) throws ParseException {
        if (address == null) {
            List<CreateAddressModel> newAddress = new ArrayList<>();
            newAddress.add(addressModel);
            eventModel.setAddress(newAddress);
            this.eventService.createEvent(eventModel);
        } else {
            List<GetAddressModel> addresses = address.stream()
                    .map(ad -> {
                        try {
                            GetShopModel shop = this.shopService.findByName(ad);
                            return this.modelMapper.map(shop.getAddress(), GetAddressModel.class);
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            CreateEventWithoutAddressModel noAddressModel = this.modelMapper.map(eventModel, CreateEventWithoutAddressModel.class);
            noAddressModel.setAddress(addresses);
            this.eventService.createEventWithoutAddress(noAddressModel);
        }
        return "redirect:/home/welcome";
    }

    @GetMapping("/all-events")
    public String getEvents(Model model) {
        List<GetEventModel> events = this.eventService.getAllEvents()
                .stream()
                .map(e -> this.modelMapper.map(e, GetEventModel.class))
                .collect(Collectors.toList());
        model.addAttribute("events", events);
        return "events/all-events";
    }

    @GetMapping("/event-details/{id}")
    public ModelAndView getEventDetails(@PathVariable String id, ModelAndView modelAndView) throws Exception {
        GetEventModel event = this.modelMapper.map(this.eventService.findById(id), GetEventModel.class);
        modelAndView.addObject("event", event);
        modelAndView.setViewName("/events/event-details.html");
        return modelAndView;
    }

    @GetMapping("/edit-event/{id}")
    public ModelAndView getEditEvent(@PathVariable String id, ModelAndView modelAndView) throws Exception {
        GetEventModel event = this.modelMapper.map(this.eventService.findById(id), GetEventModel.class);
        List<GetAddressModel> addresses = this.addressService.findAll()
                .stream()
                .map(a -> this.modelMapper.map(a, GetAddressModel.class))
                .filter(ad -> {
                    List<String> adrIds = event.getAddress().stream().map(GetAddressModel::getId).collect(Collectors.toList());
                    return !adrIds.contains(ad.getId());
                })
                .collect(Collectors.toList());
        modelAndView.addObject("event", event);
        modelAndView.addObject("notPresentedAddresses", addresses);
        modelAndView.setViewName("/events/edit-event.html");
        return modelAndView;
    }

    @PostMapping("/edit-event/{id}")
    public String editEvent(@PathVariable String id,
                            @ModelAttribute CreateAddressModel addressModel,
                            @ModelAttribute GetAddressModel getAddressModel,
                            @ModelAttribute UpdateEventModel eventModel,
                            @RequestParam(value = "shopCheckbox", required = false) List<String> address) throws Exception {

        if (address == null) {
            eventModel.setAddress(Arrays.asList(this.modelMapper.map(addressModel, GetAddressModel.class)));
        } else {
            List<GetAddressModel> addresses = address
                    .stream()
                    .map(ad -> {
                        try {

                            GetAddressModelService adrs = this.addressService.getAddressWithId(ad);
                            GetAddressModel adrr = this.modelMapper.map(adrs, GetAddressModel.class);
                            return adrr;
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            eventModel.setAddress(addresses);
        }

        this.eventService.updateEvent(this.modelMapper.map(eventModel, GetEventModelService.class));
        return "events/all-events.html";
    }
}

