package servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;
import services.UserService;
import services.UserServiceImp;

import javax.servlet.http.HttpSession;
@Controller
public class Controller1 {
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
    public String checklogin(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
     UserService userService = new UserServiceImp();
        User user = userService.getUserService(login, password);
        if (user != null) {
            return "goods";
        } else {
            return "faillogin";
        }
    }

    @RequestMapping(value = "/checkregistartion", method = RequestMethod.POST)
    public String checkRegistartion(@RequestParam(value = "name") String mane, @RequestParam(value = "login") String login,
                                    @RequestParam(value = "age") Long age, @RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password, @RequestParam(value = "pswRepeat") String pswRepeat) {
        UserService userService = new UserServiceImp();
        if (password.equals(pswRepeat)) {

            return "successregistration";
        } else {
            return "failinpswrepeat";
        }
    }
}
