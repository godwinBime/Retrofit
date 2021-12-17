package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("picture_url")
    @Expose
    private String profilePicture;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("club")
    @Expose
    private String club;

    @SerializedName("gender")
    @Expose
    private String gender;


    @SerializedName("site")
    @Expose
    private String site;

    @SerializedName("origin")
    @Expose
    private String origin;

    public void setProfilePicture(String profilePicture){
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture(){
        return profilePicture;
    }

    public void setPlayerName(String name){
        this.name = name;
    }

    public String getPlayerName(){
        return name;
    }

    public void setClub(String club){
        this.club = club;
    }

    public String getClub(){
        return club;
    }

    public void setSite(String site){
        this.site = site;
    }

    public String getSite(){
        return site;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }
}


