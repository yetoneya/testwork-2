package ru.elena.testwork.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.elena.testwork.dao.UserRepository;
import ru.elena.testwork.domain.User;
import ru.elena.testwork.base.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    
    
    private  UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
   }
    
    @Override
    public void deleteAll() {
        userRepository.deleteAll();        
    }
    
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
