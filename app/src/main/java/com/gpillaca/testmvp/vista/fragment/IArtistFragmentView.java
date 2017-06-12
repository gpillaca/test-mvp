package com.gpillaca.testmvp.vista.fragment;

import com.gpillaca.testmvp.model.Artist;
import com.gpillaca.testmvp.adapter.ArtistAdapter;

import java.util.ArrayList;

/**
 * Created by gefer on 27/05/2017.
 */

public interface IArtistFragmentView {

    void generarGridLayout();
    ArtistAdapter crearAdaptador(ArrayList<Artist> artists);
    void inicializarAdaptadorRV(ArtistAdapter adapter);

}
