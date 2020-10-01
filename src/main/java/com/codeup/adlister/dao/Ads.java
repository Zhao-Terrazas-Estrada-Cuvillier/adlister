package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    void insert(Ad ad);

    // grabs ads my it's ID
    Ad getAdByID(long ad_id);

    //updates an ad in the database
    void updateAd(Ad ad);

    //remove an ad from the database
    void deleteAd(Ad ad);

}
