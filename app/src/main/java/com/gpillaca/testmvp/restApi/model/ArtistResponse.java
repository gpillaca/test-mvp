package com.gpillaca.testmvp.restApi.model;

import com.gpillaca.testmvp.model.Artist;

import java.util.ArrayList;

/**
 * Created by gefer on 26/05/2017.
 */

public class ArtistResponse {

    private ArrayList<Artist> artists;

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }
}
