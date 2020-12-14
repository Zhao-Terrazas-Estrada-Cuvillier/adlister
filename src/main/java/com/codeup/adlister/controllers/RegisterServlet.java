package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            request.setAttribute("error", "nothing can be empty!");
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        try {
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        } catch (RuntimeException e) {
            e.printStackTrace();
            SQLException se = (SQLException) e.getCause();
            System.out.println(se.getSQLState());
            switch (se.getSQLState()) {
                case "23000":
                    request.setAttribute("error", "That username already exists! Please pick another one.");
                    break;
                default:
                    request.setAttribute("error", "Invalid Login!");
                    break;
            }
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
