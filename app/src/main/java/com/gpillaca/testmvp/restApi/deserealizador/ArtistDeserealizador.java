package com.gpillaca.testmvp.restApi.deserealizador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.gpillaca.testmvp.model.Artist;
import com.gpillaca.testmvp.restApi.JsonKeys;
import com.gpillaca.testmvp.restApi.model.ArtistResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by gefer on 27/05/2017.
 */

public class ArtistDeserealizador implements JsonDeserializer<ArtistResponse>{
    @Override
    public ArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        ArtistResponse artistResponse = gson.fromJson(json, ArtistResponse.class);

        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.RESPONSE_OBJECT_ARTIST);
        JsonArray artistResponseDataArray = artistResponseData.getAsJsonArray(JsonKeys.RESPONSE_ARRAY_ARTIST);

        artistResponse.setArtists(deserializadorArtistJson(artistResponseDataArray));

        return artistResponse;
    }

    private ArrayList<Artist> deserializadorArtistJson(JsonArray artistResponseDataArray){
        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < artistResponseDataArray.size(); i++){
            JsonObject artistData = artistResponseDataArray.get(i).getAsJsonObject();

            Artist artist = new Artist();
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            JsonArray imageArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGE);
            String[] images = artistImagenesArray(imageArray);

            artist.setName(name);
            artist.setUrlFoto(images[1]);

            artists.add(artist);
        }

        return  artists;
    }

    private String[] artistImagenesArray(JsonArray imagesArray){
        String[] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++){
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String url = imageData.get(JsonKeys.ARTIST_URL).getAsString();
            String size = imageData.get(JsonKeys.ARTIST_URL_SIZE).getAsString();

            url = url.replaceAll("\\/","/");

            if (url.isEmpty()) {
                url = null;
            }

            if ( size.matches(JsonKeys.IMAGE_MEDIUM)) {
                images[0] = url;
            } else if (size.matches(JsonKeys.IMAGE_LARGE)){
                images[1] = url;
            }

        }

        return images;
    }
}
