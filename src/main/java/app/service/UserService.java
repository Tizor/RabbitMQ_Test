package app.service;

import app.entity.User;

import java.util.Collection;

public interface UserService {
    Collection<User> getUserList();
    User getUserById(Long id);
    void sendStringMessage(String message);
    void sendUserMessage(User user);
    void changeUserMessageFromFirstQueue(User user);
}
