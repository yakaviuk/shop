package servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Indent;
import pojo.User;
import services.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Controller1 {
    GoodsService goodsService = new GoodsServiceImp();
    IndentService indentService = new IndentServiceImp();

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
        User user = userService.getUserService(login.toLowerCase(), password);
        if (user != null) {
            req.setAttribute("goodsAll", goodsService.findAll());
            req.getSession().setAttribute("name", user.getName());
            req.getSession().setAttribute("login", user.getLogin());
            req.getSession().setAttribute("userId", user.getIdUser());
            return "goods";
        } else {
            return "faillogin";
        }
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public String checklogin(@RequestParam(value = "login") String login, HttpServletRequest req) {
        User user = (new UserServiceImp().getUserByLoginService(login.toLowerCase()));
        if (user != null) {
            req.setAttribute("goodsAll", goodsService.findAll());
            req.getSession().setAttribute("name", user.getName());
            req.getSession().setAttribute("login", user.getLogin());
            req.getSession().setAttribute("userId", user.getIdUser());
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
                        userService.createUser(new User(name, login.toLowerCase(), age, email, password));
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

    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public String checkRegistartion(@RequestParam(value = "login") String login, HttpServletRequest req) {
        User user = new UserServiceImp().getUserByLoginService(login.toLowerCase());
        req.getAttribute(login);
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("name", user.getName());
        req.getSession().setAttribute("age", user.getAge());
        req.getSession().setAttribute("email", user.getEmail());
        return "userinfo";
    }

    @RequestMapping(value = "/orderitem", method = RequestMethod.POST)
    public String orderItem(@RequestParam(value = "login") String login, @RequestParam(value = "idGoods") Long idGoods, HttpServletRequest req) {
        User user = (new UserServiceImp().getUserByLoginService(login));
        req.setAttribute("goodsAll", goodsService.findAll());
        req.getSession().setAttribute("name", user.getName());
        req.getSession().setAttribute("login", user.getLogin());
        req.getSession().setAttribute("userId", user.getIdUser());
        indentService.createIndent(new Indent( user.getIdUser(), idGoods ));
        return "goods";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String orderAllChosen (@RequestParam(value = "userId") Long userId, HttpServletRequest req) {
IndentService indentService = new IndentServiceImp();

        req.setAttribute("cartList", indentService.getCartList(userId));
        return "cart";
    }
}
