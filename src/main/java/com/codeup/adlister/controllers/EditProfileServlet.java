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

@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username_edit = request.getParameter("username");
        String email_edit = request.getParameter("email");
        String password_edit = request.getParameter("password");
        String passwordConfirmation_edit = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username_edit.isEmpty()
                || email_edit.isEmpty()
                || password_edit.isEmpty();
        boolean password_notmatch= !password_edit.equals(passwordConfirmation_edit);

        if (inputHasErrors) {
            request.setAttribute("error", "Nothing should be empty");
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
            return;
        }
        if (password_notmatch) {
            request.setAttribute("error", "Password not match");
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
            return;
        }

        User sessionUser = (User) request.getSession().getAttribute("user");
        // create and save a new user
        User user_edit = new User(username_edit, email_edit, password_edit);
        user_edit.setId(sessionUser.getId());

        if (!user_edit.equals(request.getSession().getAttribute("user"))) {
            try {
                DaoFactory.getUsersDao().editUsername(user_edit);
                request.getSession().setAttribute("user",user_edit);
                response.sendRedirect("/profile");
            } catch (RuntimeException e) {
                e.printStackTrace();
                SQLException se = (SQLException) e.getCause();
                System.out.println(se.getSQLState());
                switch (se.getSQLState()) {
                    case "23000":
                        request.setAttribute("error", "That username already exists! Please pick another one.");
                        break;
                    default:
                        request.setAttribute("error", "Invalid update profile!");
                        break;
                }
                request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
            }

        }


    }
}
