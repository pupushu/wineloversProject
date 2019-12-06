package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.data.models.user.User;
import softuni.winelovers.data.models.wine.Wine;
import softuni.winelovers.data.models.wine.WineComment;
import softuni.winelovers.data.repositories.user.UserRepository;
import softuni.winelovers.data.repositories.wine.WineCommentRepository;
import softuni.winelovers.service.models.wines.CreateWineCommentModelService;
import softuni.winelovers.service.services.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final ModelMapper modelMapper;
    private final WineCommentRepository wineCommentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(ModelMapper modelMapper, WineCommentRepository wineCommentRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.wineCommentRepository = wineCommentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(CreateWineCommentModelService commentModelService) {
        WineComment comments = this.modelMapper.map(commentModelService, WineComment.class);

        User user = this.userRepository.findByUsername(comments.getUser().getUsername()).get();
        comments.setUser(null);
        this.wineCommentRepository.save(comments);
        comments.setUser(user);
        this.wineCommentRepository.save(comments);
    }
}
