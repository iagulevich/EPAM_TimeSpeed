package controllers;

import dao.UserStorage;
import domain.dao_models.User;
import domain.dao_models.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/registration")
public class RegistrationController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            User user = UserFactory.create(name, login, password);
            UserStorage storage = UserStorage.getInstance();
            if (!storage.isFound(user)) {
                storage.addUser(user);
                forward("/index.jsp", req, resp);
            }
            forwardError("/jsp/registration.jsp", "user already exist", req, resp);
        } catch (Exception e) {
            forwardError("/jsp/registration.jsp", e.getMessage(), req, resp);
        }


    }
}
