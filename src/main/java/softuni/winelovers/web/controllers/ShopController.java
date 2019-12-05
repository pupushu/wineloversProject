package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.service.models.addresses.CreateAddressModelService;
import softuni.winelovers.service.models.shops.CreateShopModelService;
import softuni.winelovers.service.models.shops.GetShopModelService;
import softuni.winelovers.service.services.AddressService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.web.models.addresses.CreateAddressModel;
import softuni.winelovers.web.models.addresses.GetAddressModel;
import softuni.winelovers.web.models.shop.CreateShopModel;
import softuni.winelovers.web.models.shop.GetShopModel;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shops")
public class ShopController {
    private final ModelMapper modelMapper;
    private final ShopService shopService;

    @Autowired
    public ShopController(ModelMapper modelMapper, ShopService shopService) {
        this.modelMapper = modelMapper;
        this.shopService = shopService;
    }

    @GetMapping("/add-shop")
    public String getCreateShop(){
        return "/shops/add-shop.html";
    }

    @PostMapping("/add-shop")
    public String createShop(@ModelAttribute CreateShopModel shopModel,
                             @ModelAttribute CreateAddressModel addressModel) throws Exception {
        shopModel.setAddress(addressModel);
        this.shopService.create(this.modelMapper.map(shopModel, CreateShopModelService.class));
        return "/home/welcome.html";
    }

    @GetMapping("/all-shops")
    public String getAllShops(Model model) {
        List<GetShopModel> shops = this.shopService.findAll()
                .stream()
                .map(shop -> this.modelMapper.map(shop, GetShopModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allShops", shops);
        return "shops/all-shops.html";
    }

    @GetMapping("/edit-shop/{id}")
    public ModelAndView getEditShop(@PathVariable String id, ModelAndView modelAndView) throws Exception {
        GetShopModel shop = this.modelMapper.map(this.shopService.findById(id), GetShopModel.class);
        modelAndView.setViewName("shops/edit-shop.html");
        modelAndView.addObject("shop", shop);
        return modelAndView;
    }

    @PostMapping("/edit-shop/{id}")
    public String editShop(@PathVariable String id,
                           @ModelAttribute GetShopModel shopModel,
                           @ModelAttribute GetAddressModel addressModel){
        shopModel.setId(id);
        shopModel.setAddress(addressModel);
        this.shopService.update(this.modelMapper.map(shopModel, GetShopModelService.class));
        System.out.println();
        return "redirect:/shops/all-shops";
    }


}
