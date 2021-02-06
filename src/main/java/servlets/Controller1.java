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
        User user1 = (new UserServiceImp().getUserByLoginService(login.toLowerCase()));
        if (user1.getIdUser() == null) {
            return "faillogin";
        } else if (PasswordUtils.verifyUserPassword(password, new UserServiceImp().getUserByLoginService(login.toLowerCase()).getPassword(), new UserServiceImp().getUserByLoginService(login.toLowerCase()).getSalt())) {
            User user = (new UserServiceImp().getUserByLoginService(login.toLowerCase()));
            req.setAttribute("goodsAll", new GoodsServiceImp().findAll());
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
            req.setAttribute("goodsAll", new GoodsServiceImp().findAll());
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
        if (new UserServiceImp().getUserServiceCheckIfUserExists(login) == null) {
            if (new UserServiceImp().getUserServiceCheckIfUserExistsByEmail(email) == null) {
                if (age >= 18) {
                    if (password.equals(pswRepeat)) {
                        String salt = PasswordUtils.getSalt(30);
                        String securePassword = PasswordUtils.generateSecurePassword(password, salt);
                        if (new UserServiceImp().createUser(new User(name, login.toLowerCase(), age, email, securePassword, salt))) {
                            return "successregistration";
                        } else {
                            return "otherfail";
                        }
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
        req.setAttribute("goodsAll", new GoodsServiceImp().findAll());
        req.getSession().setAttribute("name", user.getName());
        req.getSession().setAttribute("login", user.getLogin());
        req.getSession().setAttribute("userId", user.getIdUser());
        new IndentServiceImp().createIndent(new Indent(user.getIdUser(), idGoods));
        return "goods";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String openCart(@RequestParam(value = "userId") Long userId, HttpServletRequest req) {
        req.setAttribute("cartList", new IndentServiceImp().getCartList(userId));
        req.setAttribute("sum", new IndentServiceImp().getSum(userId));
        return "cart";
    }

    @RequestMapping(value = "/orderall", method = RequestMethod.POST)
    public String orderAllChosen(@RequestParam(value = "userId") Long userId, HttpServletRequest req) {
        req.getSession().setAttribute("userId", userId);
        req.setAttribute("sum", new IndentServiceImp().getSum(userId));
        if (new IndentServiceImp().setIndentZero(userId)) {
            return "paid";
        } else {
            return "errorinpay";
        }
    }

    @RequestMapping(value = "/paid", method = RequestMethod.POST)
    public String paidPage(@RequestParam(value = "userId") Long userId, HttpServletRequest req) {
        req.setAttribute("sum", new IndentServiceImp().getSum(userId));
        return "paid";
    }
}