package com.gpillaca.testmvp.presentador;

import android.content.Context;

import com.google.gson.Gson;
import com.gpillaca.testmvp.model.Artist;
import com.gpillaca.testmvp.restApi.LastFmApiService;
import com.gpillaca.testmvp.restApi.adapter.RestApiAdapter;
import com.gpillaca.testmvp.restApi.model.ArtistResponse;
import com.gpillaca.testmvp.vista.fragment.IArtistFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gefer on 27/05/2017.
 */

public class ArtistFragmentPresenter implements IArtistFragmentPresenter {

    private IArtistFragmentView iArtistFragmentView;
    private Context context;

    private ArrayList<Artist> artists;

    public ArtistFragmentPresenter(IArtistFragmentView iArtistFragmentView, Context context) {
        this.iArtistFragmentView = iArtistFragmentView;
        this.context = context;
        obtenerArtistas();
    }

    @Override
    public void obtenerArtistas() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonArtist = restApiAdapter.construyeGsonDeserealizadorArtist();

        LastFmApiService lastFmApiService = restApiAdapter.establecerConexionRestApi(gsonArtist);

        Call<ArtistResponse> artistResponseCall = lastFmApiService.getArtist();

        artistResponseCall.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
                if (response.isSuccessful()) {
                    ArtistResponse artistResponse = response.body();
                    artists = artistResponse.getArtists();
                    mostrarArtistasRV();


                }

            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void mostrarArtistasRV() {
        iArtistFragmentView.generarGridLayout();
        iArtistFragmentView.inicializarAdaptadorRV(iArtistFragmentView.crearAdaptador(artists));


    }
}
