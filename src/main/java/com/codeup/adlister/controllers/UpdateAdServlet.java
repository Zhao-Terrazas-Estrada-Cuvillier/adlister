package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }
        request.getRequestDispatcher("WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title_update = request.getParameter("title");
        String description_update = request.getParameter("description");
        //validate input
        boolean inputHasErrors = title_update.isEmpty() || description_update.isEmpty();
        if (inputHasErrors) {
            request.setAttribute("error", "title or description can't be empty");
            request.getRequestDispatcher("WEB-INF/ads/update.jsp").forward(request, response);
        }
        Ad sessionAd = (Ad) request.getSession().getAttribute("ad");
        //create and save a new ad
        Ad ad_update = new Ad(sessionAd.getUserId(), title_update, description_update);
        ad_update.setId(sessionAd.getId());
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }
}