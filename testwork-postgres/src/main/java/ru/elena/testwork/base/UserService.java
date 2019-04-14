package ru.elena.testwork.base;

import ru.elena.testwork.domain.User;
import java.util.List;

public interface UserService {
    
    User findById(long id);
    
    List<User> findAll();
    
    User save(User user);
    
    void deleteAll();
    
}
