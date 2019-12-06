package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.service.models.wines.CreateWineModelService;
import softuni.winelovers.service.models.wines.GetWineModelService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.service.services.WineService;
import softuni.winelovers.web.models.shop.GetShopModel;
import softuni.winelovers.web.models.wines.CreateWineModel;
import softuni.winelovers.web.models.wines.CreateWineWineNotesModel;
import softuni.winelovers.web.models.wines.GetWineModel;
import softuni.winelovers.web.models.wines.GetWineNoteModel;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/wines")
public class WineController {
    private final ShopService shopService;
    private final WineService wineService;
    private final ModelMapper modelMapper;

    @Autowired
    public WineController(ShopService shopService, WineService wineService, ModelMapper modelMapper) {
        this.shopService = shopService;
        this.wineService = wineService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add-wine")
    public String getAddWines(Model model){
        List<GetShopModel> shops = this.shopService.findAll()
                .stream()
                .map(shop -> this.modelMapper.map(shop, GetShopModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allShops", shops);
        return "wines/add-wine";
    }

    @PostMapping("/add-wine")
    public String addWine(@ModelAttribute CreateWineModel model,
                          @RequestParam(value = "shopCheckbox", required = false) List<String> shops,
                          @ModelAttribute CreateWineWineNotesModel notesModel){
        model.setWineNotes(notesModel);
        this.wineService.createWine(this.modelMapper.map(model, CreateWineModelService.class), shops);

        return "redirect:/home/welcome";
    }

    @GetMapping("all-wines")
    public String getAllWines(Model model){
        List<GetWineModel> wines = this.wineService.getAll().stream()
                .map(wine -> this.modelMapper.map(wine, GetWineModel.class))
                .collect(Collectors.toList());
        model.addAttribute("wines", wines);
        return "wines/all-wines";
    }

    @GetMapping("/wine-details/{id}")
    public ModelAndView getNewsDetails(@PathVariable String id, ModelAndView modelAndView,
                                       HttpSession session){
        try {
            GetWineModel toDisplay = this.modelMapper.map(this.wineService.findById(id), GetWineModel.class);
            modelAndView.addObject("wine", toDisplay);
            modelAndView.setViewName("wines/wine-details.html");
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("home/welcome.html");
            return modelAndView;
        }
    }

    @GetMapping("/edit-wine/{id}")
    public String getEditWine(@PathVariable String id,
                              Model model) throws Exception {
        GetWineModel wine = this.modelMapper.map(this.wineService.findById(id), GetWineModel.class);
        List<GetShopModel> shopsNotSelected = this.shopService.findAll().stream()
                .map(sh -> this.modelMapper.map(sh, GetShopModel.class))
                .filter(shopModel -> {
                    List<String> shopIds = wine.getWhereToBuy().stream().map(GetShopModel::getId).collect(Collectors.toList());
                    return !shopIds.contains(shopModel.getId());
                }).collect(Collectors.toList());
        model.addAttribute("wine", this.modelMapper.map(wine, GetWineModel.class));
        model.addAttribute("shopsNotSelected", shopsNotSelected);
        return "wines/edit-wine";
    }

    @PostMapping("/edit-wine/{id}")
    public String editWine(@PathVariable String id,
                           @ModelAttribute GetWineModel wineModel,
                           @ModelAttribute GetWineNoteModel noteModel,
                           @RequestParam(value = "shopCheckbox", required = false) List<String> address) throws Exception {
       GetWineModel wine = this.modelMapper.map(wineModel, GetWineModel.class);
       List<GetShopModel> shops = address.stream()
               .map(a -> {
                   try {
                       return this.modelMapper.map(this.shopService.findById(a), GetShopModel.class);
                   } catch (Exception e) {
                       return null;
                   }
               }).collect(Collectors.toList());
       noteModel.setWine(wine);
       wine.setWineNote(noteModel);
       wine.setWhereToBuy(shops);
        wine.setId(id);
        System.out.println();
       this.wineService.update(this.modelMapper.map(wine, GetWineModelService.class));
        return "wines/all-wines";
    }
}
