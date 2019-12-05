package softuni.winelovers.service.services;

import softuni.winelovers.data.models.news.News;
import softuni.winelovers.service.models.news.NewsCreateServiceModel;
import softuni.winelovers.service.models.news.UpdateNewsModelService;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    void createNews(NewsCreateServiceModel model);

    List<News> findAll();

    News findById(String id) throws Exception;

    void update(UpdateNewsModelService model);
}
