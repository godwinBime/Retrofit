package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlayerDetails extends AppCompatActivity {
    private static final String LOG_TAG = PlayerDetails.class.getSimpleName();
    public  static final String DETAIL_PROFILE = "detail_profile";
    public static final int PROFILE_REQUEST = 1;
    private CircleImageView imgDetailProfilePicture;
    private TextView txtDetailPlayerName;
    private TextView txtGender;
    private TextView txtClub;
    private TextView txtSite;
    private TextView txtDOB;
    private TextView txtOrigin;
    private TextView txtStatus;
    private String selectedProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        imgDetailProfilePicture = findViewById(R.id.imgDetailsPlayerID);
        txtDetailPlayerName = findViewById(R.id.txtDetailsPlayerNameId);
        txtGender = findViewById(R.id.txtGenderID);
        txtClub = findViewById(R.id.txtClubID);
        txtSite = findViewById(R.id.txtSiteID);
        txtDOB = findViewById(R.id.txtDOBID);
        txtOrigin = findViewById(R.id.txtOriginID);
        txtStatus = findViewById(R.id.txtMStatusID);
        getProfile();
    }

    private void getProfile(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/godwinBime/6eca1d76b619142a2b76c8631f7ce772/raw/75295c5eefaaee7962371108bb272468ab64a5ad/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Player>> call = jsonPlaceHolderAPI.getDetailPlayer();

        call.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                if (!response.isSuccessful()){
                    txtDetailPlayerName.setText("Code: " + response.code());
                    return;
                }
                List<Player> detailPlayerProfile = response.body();
                for (Player detailPlayer : detailPlayerProfile){
                    if (detailPlayer.getDetailsId().equals("8")){
                        String froName = "";
                        froName += "Name:\t"  + detailPlayer.getDetailPlayerName() +
                                "\nGender: " + detailPlayer.getGender() +
                                "\nClub:   "   + detailPlayer.getClub() +
                                "\nSite:   "   + detailPlayer.getSite() +
                                "\nDOB:    "    + detailPlayer.getDOB() +
                                "\nOrigin: " + detailPlayer.getOrigin() +
                                "\nStatus: " + detailPlayer.getStatus();
                        txtDetailPlayerName.append(froName);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                txtDetailPlayerName.setText(t.getMessage());
            }
        });
    }
}