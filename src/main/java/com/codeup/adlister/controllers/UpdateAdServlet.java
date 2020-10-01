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
        if (request.getSession().getAttribute("ad") != null) {
            Ad adEdit = (Ad) request.getSession().getAttribute("ad");
        }
        request.getRequestDispatcher("WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long ad_id = Long.parseLong(request.getParameter("ad_id"));
        Ad adToEdit = DaoFactory.getAdsDao().getAdByID(ad_id);
        String title = request.getParameter("title");
        String description = adToEdit.getDescription();

        //validate input
        boolean inputHasErrors = title.isEmpty() || description.isEmpty();

        if (inputHasErrors) {
            request.setAttribute("error", "Error handling your request");
            request.getRequestDispatcher("WEB-INF/ads/update.jsp").forward(request, response);
        }

        Ad sessionAd = (Ad) request.getSession().getAttribute("ad");
        //create and save a new ad
        Ad ad_edit = new Ad(title, description);
        ad_edit


    }
}