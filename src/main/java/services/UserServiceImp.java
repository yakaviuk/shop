package services;

import dataBase.UserDAO;
import dataBase.UserDAOImp;
import pojo.User;

public class UserServiceImp implements UserService {
    UserDAO userDAO;

    public User getUser(String login) {
        userDAO = new UserDAOImp();
        return userDAO.getUser(login);
    }

    public boolean createUser(User user) {
        userDAO = new UserDAOImp();
        return userDAO.createUser(user);
    }
}
