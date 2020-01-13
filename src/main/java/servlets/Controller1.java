package servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;
import services.GoodsService;
import services.GoodsServiceImp;
import services.UserService;
import services.UserServiceImp;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Controller1 {
    GoodsService goodsService = new GoodsServiceImp();

    @RequestMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/registration")
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String checklogin(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password, HttpServletRequest req) {
        UserService userService = new UserServiceImp();
        User user = userService.getUserService(login, password);
        if (user != null) {
            req.setAttribute("goodsAll", goodsService.findAll());
            return "goods";
        } else {
            return "faillogin";
        }
    }

    @RequestMapping(value = "/checkregistartion", method = RequestMethod.POST)
    public String checkRegistartion(@RequestParam(value = "name") String name, @RequestParam(value = "login") String login,
                                    @RequestParam(value = "age") Integer age, @RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password, @RequestParam(value = "pswRepeat") String pswRepeat) {
        UserService userService = new UserServiceImp();
        if (userService.getUserServiceCheckIfUserExists(login) == null) {
            if (userService.getUserServiceCheckIfUserExistsByEmail(email) == null) {
                if (age >= 18) {
                    if (password.equals(pswRepeat)) {
                        userService.createUser(new User(name, login, age, email, password));
                        return "successregistration";
                    } else {
                        return "failinpswrepeat";
                    }
                } else {
                    return "failinage";
                }
            } else {
                return "failinemail";
            }
        } else {
            return "failinlogin";
        }
    }
}
