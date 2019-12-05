package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.data.models.news.News;
import softuni.winelovers.service.models.news.NewsCreateServiceModel;
import softuni.winelovers.service.models.news.UpdateNewsModelService;
import softuni.winelovers.service.services.NewsService;
import softuni.winelovers.web.models.news.EditNewsModel;
import softuni.winelovers.web.models.news.NewsCreateModel;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final ModelMapper modelMapper;
    private final NewsService newsService;

    @Autowired
    public NewsController(ModelMapper modelMapper, NewsService newsService) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
    }

    @GetMapping("/create-news")
    public String getCreateNews(){
        return "/news/create-news";
    }

    @PostMapping("/create-news")
    public String createNews(@ModelAttribute NewsCreateModel model){
        this.newsService.createNews(this.modelMapper.map(model, NewsCreateServiceModel.class));

        return "redirect:/home/welcome";
    }

    @GetMapping("/all-news")
    public String getAllNews(Model model){
        List<News> newsList = this.newsService.findAll();
        model.addAttribute("newsList", newsList);
        return "news/all-news";
    }

    @GetMapping("/details/{id}")
    public ModelAndView getNewsDetails(@PathVariable String id, ModelAndView modelAndView){
        try {
            News toDisplay = this.newsService.findById(id);
            modelAndView.addObject("news", toDisplay);
            modelAndView.setViewName("news/news-details.html");
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("news/all-news.html");
            return modelAndView;
        }
    }

    @GetMapping("/edit-news/{id}")
    public ModelAndView getEditNews(@PathVariable String id, ModelAndView modelAndView) throws Exception {
        News news = null;
        try {
            news = this.newsService.findById(id);
        } catch (Exception e) {
            throw new Exception("News not found");
        }
        modelAndView.addObject("news", news);
        modelAndView.setViewName("news/edit-news.html");
        return modelAndView;
    }

    @PostMapping("/edit-news/{id}")
    public String editNews(@PathVariable String id,
                                 @ModelAttribute EditNewsModel newsModel) {
        this.newsService.update(this.modelMapper.map(newsModel, UpdateNewsModelService.class));
        return "redirect:/news/all-news";
    }
}
