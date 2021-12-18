package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("picture_url")
    @Expose
    private String detailProfilePicture;

    @SerializedName("name")
    @Expose
    private String detailName;

    @SerializedName("club")
    @Expose
    private String club;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("site")
    @Expose
    private String site;

    @SerializedName("origin")
    @Expose
    private String origin;

    @SerializedName("status")
    @Expose
    private String status;

    public int getDetailsId(){
        return id;
    }

    public String getDetailProfilePicture(){
        return detailProfilePicture;
    }

    public String getDetailPlayerName(){
        return detailName;
    }

    public String getClub(){
        return club;
    }

    public String getSite(){
        return site;
    }

    public String getGender(){
        return gender;
    }

    public String getDOB(){
        return dob;
    }

    public String getStatus(){
        return status;
    }

    public String getOrigin(){
        return origin;
    }
}


