package services;

import pojo.User;

public interface UserService {
    User getUser(String login);
    boolean createUser(User user);

}
