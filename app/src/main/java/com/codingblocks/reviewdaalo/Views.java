package com.codingblocks.reviewdaalo;

/**
 * Created by Aakarshak on 24-01-2017.
 */

public class Views {

    String Moviename;
    String Review;
    float rating;
    String name;

    public Views(String moviename, String name, float rating, String review) {
        Moviename = moviename;
        this.name = name;
        this.rating = rating;
        Review = review;
    }

    public String getMoviename() {
        return Moviename;
    }

    public String getReview() {
        return Review;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
}
