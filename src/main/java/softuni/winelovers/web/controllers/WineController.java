package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.data.models.news.News;
import softuni.winelovers.data.models.wine.Wine;
import softuni.winelovers.data.models.wine.WineNote;
import softuni.winelovers.service.models.user.UserLoginServiceModel;
import softuni.winelovers.service.models.wines.CreateWineModelService;
import softuni.winelovers.service.services.ShopService;
import softuni.winelovers.service.services.WineService;
import softuni.winelovers.web.models.news.NewsCreateModel;
import softuni.winelovers.web.models.shop.GetShopModel;
import softuni.winelovers.web.models.users.LoginUserModel;
import softuni.winelovers.web.models.wines.CreateWineModel;
import softuni.winelovers.web.models.wines.CreateWineWineNotesModel;
import softuni.winelovers.web.models.wines.GetWineModel;

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
            Wine toDisplay = this.wineService.findById(id);
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
                              @ModelAttribute GetWineModel getWineModel,
                              Model model) throws Exception {
        Wine wine = this.wineService.findById(id);
        model.addAttribute("wine", this.modelMapper.map(wine, GetWineModel.class));
        return "wines/edit-wine";
    }

    @PostMapping("/edit-wine/{id}")
    public String editWine(@PathVariable String id,
                           @ModelAttribute GetWineModel wineModel,
                           @ModelAttribute WineNote noteModel) throws Exception {
       Wine wine = this.modelMapper.map(wineModel, Wine.class);
       wine.setWineNote(noteModel);
       wine.setId(id);
       this.wineService.update(wine);
        return "wines/all-wines";
    }
}
