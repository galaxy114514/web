package servlet;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;
import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = "*.login")
public class LoginServlet extends BaseServlet {
    User user = new User();
    UserDao dao = new UserDaoImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        BeanUtils.populate(user, req.getParameterMap());
        System.out.println(user);
        Cookie[] cookies = req.getCookies();
        if (user.getUsername() == null || user.getPassword() == null) {
            if (cookies != null) {
                System.out.println("entry cookie");
                String username = CookieUtils.getCookieValue(cookies, "username");
                String password = CookieUtils.getCookieValue(cookies, "password");
                System.out.println(username);
                System.out.println(password);
                User user = new User(username, password);
                User query1 = dao.query(user);
                if (query1 != null) {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/index.jsp").include(req, resp);
                    return;
                }
            }else {
                resp.sendRedirect("/web/login.jsp");
            }
        }

        User query = dao.query(user);
        if (query != null) {
            System.out.println("entry login");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/index.jsp").include(req, resp);
            Cookie username=CookieUtils.getCookie("username",query.getUsername());
            Cookie password=CookieUtils.getCookie("password",query.getPassword());
            resp.addCookie(username);
            resp.addCookie(password);
        } else {
            System.out.println("entry login error");
            req.setAttribute("user", user);
            req.setAttribute("message", "name or password mistake");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(user, req.getParameterMap());
        boolean isExist = dao.queryUsername(user);
        if (isExist) {
            req.setAttribute("message", "username is taken");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/registerUser.jsp").forward(req, resp);
        } else {
            dao.insert(user);
            req.setAttribute("message", "register success");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/registerUser.jsp").forward(req, resp);
        }
    }
}
