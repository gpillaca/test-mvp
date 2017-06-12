package com.gpillaca.testmvp.restApi;

/**
 * Created by gefer on 26/05/2017.
 */

public class ApiConstants {

    public static final String API_KEY = "d47aeb1459021b410a120a9b6d43cf8f";
    public static final String BASE_URL = "http://ws.audioscrobbler.com";
    public static final String VERSION = "/2.0";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_ARTIST = "artist";


    public static final String VALUE_ARTIST_METHOD = "artist.getSimilar";
    public static final String VALUE_JSON = "json";
    public static final String VALUE_ARTIST = "maluma";


    public static final String URL_ARTIST = VERSION + "/?" + PARAM_API_KEY + "=" + API_KEY + "&" + PARAM_METHOD +
                                            "=" + VALUE_ARTIST_METHOD + "&" + PARAM_ARTIST + "=" +
                                            VALUE_ARTIST + "&" + PARAM_FORMAT + "=" + VALUE_JSON;






}
