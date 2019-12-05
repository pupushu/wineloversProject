package softuni.winelovers.service.factories.base;

import softuni.winelovers.config.annotations.Factory;
import softuni.winelovers.data.models.news.News;
import softuni.winelovers.service.factories.NewsFactory;

import java.util.Date;

@Factory
public class NewsFactoryImpl implements NewsFactory {

    @Override
    public News create(News news) {
        News factored = news;
        factored.setDatePublished(new Date());
        return factored;
    }
}
