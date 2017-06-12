package com.gpillaca.testmvp.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gpillaca.testmvp.R;
import com.gpillaca.testmvp.model.Artist;
import com.gpillaca.testmvp.presentador.ArtistFragmentPresenter;
import com.gpillaca.testmvp.presentador.IArtistFragmentPresenter;
import com.gpillaca.testmvp.adapter.ArtistAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsFragment extends Fragment implements IArtistFragmentView{

    public static final String LOG_TAG  = ArtistsFragment.class.getName();
    public static final int NUM_COLUMNS = 2;

    private RecyclerView noticiasList;
    private ArtistAdapter artistAdapter;
    private IArtistFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_artists, container, false);
        noticiasList = (RecyclerView) root.findViewById(R.id.artist_list);

        presenter = new ArtistFragmentPresenter(this, getContext());

        return root;
    }


    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), NUM_COLUMNS);
        noticiasList.setLayoutManager(glm);

    }

    @Override
    public ArtistAdapter crearAdaptador(ArrayList<Artist> artists) {
        artistAdapter = new ArtistAdapter(getActivity());
        artistAdapter.addAll(artists);
        return artistAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(ArtistAdapter adapter) {
        noticiasList.setAdapter(artistAdapter);
        noticiasList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }
}
