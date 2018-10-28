package controllers;

import dao.UserStorage;
import domain.dao_models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/login")
public class LoginController extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);

        if (UserStorage.getInstance().isFound(user)){
           req.setAttribute("user", user);
           forward("/index.jsp", req, resp);
        };
    }
}
