package services;

import dataBase.UserDAO;
import dataBase.UserDAOImp;
import pojo.User;

public class UserServiceImp implements UserService {
    UserDAO userDAO;
@Override
    public User getUserService(String login, String password) {
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUser(login);
        if (login.equals(userTemp.getLogin()) && password.equals(userTemp.getPassword())) {
            return userDAO.getUser(login);
        } else {
            return null;
        }

    }
    @Override
    public User getUserServiceCheckIfUserExists (String login) {
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUser(login);
        if (login.equals(userTemp.getLogin())) {
            return userDAO.getUser(login);
        } else {
            return null;
        }

    }
    @Override
    public boolean createUser(User user) {
        userDAO = new UserDAOImp();
        return userDAO.createUser(user);
    }
}
