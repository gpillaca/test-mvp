package com.gpillaca.testmvp.restApi;

import com.gpillaca.testmvp.restApi.model.ArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gefer on 26/05/2017.
 */

public interface LastFmApiService {

    @GET(ApiConstants.URL_ARTIST)
    Call<ArtistResponse> getArtist();

}
