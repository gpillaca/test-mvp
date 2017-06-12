package com.gpillaca.testmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gpillaca.testmvp.R;
import com.gpillaca.testmvp.model.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by gefer on 26/05/2017.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>{

    ArrayList<Artist> artists;
    Context context;

    public ArtistAdapter(Context context) {
        this.artists = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_artists, parent, false);
        return new ArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.setArtistName(artist.getName());
        holder.setArtistImage(artist.getUrlFoto());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){
        if (artists == null) {
            throw new NullPointerException("not null");
        }

        this.artists.addAll(artists);
        notifyDataSetChanged();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder{

        private TextView artist_name;
        private ImageView artist_image;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            artist_name = (TextView) itemView.findViewById(R.id.artist_text_name);
            artist_image = (ImageView) itemView.findViewById(R.id.artist_image);
        }

        public void setArtistName(String name){
            artist_name.setText(name);
        }

        public void setArtistImage(String url){
            Picasso.with(context).load(url)
                    .placeholder(R.drawable.microfono)
                    .into(artist_image);
        }
    }
}
