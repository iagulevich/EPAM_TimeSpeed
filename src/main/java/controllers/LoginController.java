package controllers;

import dao.UserStorage;
import domain.dao_models.User;
import domain.dao_models.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/log")
public class LoginController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            User user = UserFactory.create(login, password);
            if (UserStorage.getInstance().isFound(user)) {
                req.setAttribute("user", user);
                forward("/index.jsp", req, resp);
            }
            forwardError("/jsp/login.jsp", "User not found", req, resp);
        } catch (Exception e) {
            forwardError("/jsp/login.jsp", e.getMessage(), req, resp);
        }

    }
}
