package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

    User findUserByToken(String token);

    void updateUser(User user);
}
