package softuni.winelovers.service.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.winelovers.data.models.user.User;
import softuni.winelovers.data.repositories.user.UserRepository;
import softuni.winelovers.service.factories.UserFactory;
import softuni.winelovers.service.models.user.UserLoginServiceModel;
import softuni.winelovers.service.models.user.UserProfileServiceModel;
import softuni.winelovers.service.models.user.UserRegisterServiceModel;
import softuni.winelovers.service.services.EmailService;
import softuni.winelovers.service.services.HashingService;
import softuni.winelovers.service.services.UserService;
import softuni.winelovers.web.models.users.LoginUserModel;

import javax.mail.MessagingException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final EmailService emailService;
    private final HashingService hashingService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, HashingService hashingService, UserFactory userFactory, EmailService emailService, HashingService hashingService1, ModelMapper modelMapper1) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userFactory = userFactory;
        this.hashingService = hashingService1;
        this.modelMapper = modelMapper1;
    }

    @Override
    public void register(UserRegisterServiceModel model) throws MessagingException {
       User user = userFactory.create(model.getUsername(), model.getEmail(), model.getPassword());
       this.userRepository.save(user);
       this.emailService.sendSimpleMsg(user.getEmail(), "Confirm registration", user.getMailConfirmationCode());
    }

    @Override
    public void confirmEmail(String str) {
        Optional<User> user = this.userRepository.findByMailConfirmationCode(str);
        if (user == null){
            //TODO
        }
        User userToConfirm = user.get();
        userToConfirm.setMailConfirmed(true);
        this.userRepository.save(userToConfirm);
    }

    @Override
    public UserLoginServiceModel login(LoginUserModel model) throws Exception {
        String passwordHash = this.hashingService.hash(model.getPassword());
        Optional<User> user = this.userRepository.findByUsernameAndPassword(model.getUsername(), passwordHash);
        if(user == null){
            throw new Exception("Invalid user");
        }
        User found = user.get();
        UserLoginServiceModel loginUser = this.modelMapper.map(found, UserLoginServiceModel.class);
        return loginUser;
    }

    @Override
    public UserProfileServiceModel getProfile(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).get(), UserProfileServiceModel.class);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword, String confirmNewPassword) throws Exception {
        String hashedPassword = this.hashingService.hash(oldPassword);
        Optional<User> getUser = this.userRepository.findByUsernameAndPassword(username, hashedPassword);
        if (getUser == null){
            throw new Exception("Invalid user");
        }
        if (!newPassword.equals(confirmNewPassword)){
            throw new Exception("Passwords don't match");
        }
        String hashedNewPassword = this.hashingService.hash(newPassword);
        User user = getUser.get();
        user.setPassword(hashedNewPassword);
        this.userRepository.save(user);
    }


}
