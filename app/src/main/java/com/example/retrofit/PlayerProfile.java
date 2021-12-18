package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerProfile {
    @SerializedName("id")
    @Expose
    private int userID;

    @SerializedName("picture_url")
    @Expose
    private String profilePicture;

    @SerializedName("name")
    @Expose
    private String name;

    public int getProfileUserID(){
        return userID;
    }

    public String getSummaryProfilePicture(){
        return profilePicture;
    }

    public String getSummaryPlayerName(){
        return name;
    }
}
