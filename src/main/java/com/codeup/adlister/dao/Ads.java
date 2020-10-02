package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    List<Ad> allForUser(User user);
    void deleteAd(Ad ad);

    Ad getAdByID(long ad_id);
    void updateAd(Ad ad);
}
