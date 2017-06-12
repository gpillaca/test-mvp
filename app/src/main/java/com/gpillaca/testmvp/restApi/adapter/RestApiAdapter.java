package com.gpillaca.testmvp.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpillaca.testmvp.restApi.ApiConstants;
import com.gpillaca.testmvp.restApi.LastFmApiService;
import com.gpillaca.testmvp.restApi.deserealizador.ArtistDeserealizador;
import com.gpillaca.testmvp.restApi.model.ArtistResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gefer on 27/05/2017.
 */

public class RestApiAdapter {

    public LastFmApiService establecerConexionRestApi(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(LastFmApiService.class);
    }

    public Gson construyeGsonDeserealizadorArtist(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ArtistResponse.class, new ArtistDeserealizador());

        Gson gson = gsonBuilder.create();
        return  gson;
    }

}
