package PP_3_1_1_spring_boot.service;

import PP_3_1_1_spring_boot.models.User;


import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUser(long id);
//    void updateUser(User user, long id);
    User show(long id);
}
