package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.news.News;
import softuni.winelovers.data.repositories.news.NewsRepository;
import softuni.winelovers.service.factories.NewsFactory;
import softuni.winelovers.service.models.news.NewsCreateServiceModel;
import softuni.winelovers.service.models.news.UpdateNewsModelService;
import softuni.winelovers.service.services.NewsService;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    private final ModelMapper modelMapper;
    private final NewsRepository newsRepository;
    private final NewsFactory newsFactory;

    @Autowired
    public NewsServiceImpl(ModelMapper modelMapper, NewsRepository newsRepository, NewsFactory newsFactory) {
        this.modelMapper = modelMapper;
        this.newsRepository = newsRepository;
        this.newsFactory = newsFactory;
    }

    @Override
    public void createNews(NewsCreateServiceModel model) {
        News news = this.newsFactory.create(this.modelMapper.map(model, News.class));
        this.newsRepository.save(news);
    }

    @Override
    public List<News> findAll() {
       return this.newsRepository.findAll();
    }

    @Override
    public News findById(String id) throws Exception {
        Optional<News> news = this.newsRepository.findById(id);
        if (news == null){
            throw new Exception("News details not found.");
        }
        return news.get();

    }

    @Override
    public void update(UpdateNewsModelService model) {
        News news = this.newsFactory.create(this.modelMapper.map(model, News.class));
        this.newsRepository.save(news);
    }
}
