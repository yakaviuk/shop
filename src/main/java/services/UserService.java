package services;

import pojo.User;

public interface UserService {
    User getUser(Long idUser);
    boolean createUser(String name, String login, Integer age, String email, String password);

}
