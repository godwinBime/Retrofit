package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    @GET("players_credentials.json")
    Call<List<PlayerProfile>> getPlayersProfile();

    @GET("players_credentials.json")
    Call<List<Player>> getDetailPlayer();
}
