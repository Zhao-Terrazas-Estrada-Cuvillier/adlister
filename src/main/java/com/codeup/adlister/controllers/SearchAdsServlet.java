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
import java.util.List;

@WebServlet(name = "controllers.SearchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTitle = request.getParameter("search");
        List<Ad> searchAds = DaoFactory.getAdsDao().getAdByTitle(searchTitle);
        for(Ad ad:searchAds){
            System.out.println(ad.getTitle());
        }
        request.setAttribute("ads", searchAds);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,response);
    }
}
