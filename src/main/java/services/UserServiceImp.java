package services;

import dataBase.UserDAO;
import dataBase.UserDAOImp;
import pojo.User;

public class UserServiceImp implements UserService {
    UserDAO userDAO;

    public User getUserService(String login, String password) {
        System.out.println("First: "+login + " "+password);
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUser(login);
        System.out.println(userTemp);
        if (login.equals(userTemp.getLogin())&& password.equals(userTemp.getPassword())) {

            return userDAO.getUser(login);
        } else {
            return null;
        }

    }

    public boolean createUser(User user) {
        userDAO = new UserDAOImp();
        return userDAO.createUser(user);
    }
}
