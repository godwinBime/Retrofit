package com.example.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{
    private static final String LOG_TAG = PlayerDetails.class.getSimpleName();
    public static final String PLAYER_PROFILE = "player_profile";
    private CircleImageView imgProfilePicture;
    private TextView txtPlayerName;
    private ArrayList<String> arrayListID;
    private int clickedID;
    private String playerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgProfilePicture = findViewById(R.id.imgSummaryPlayerProfilePictureID);
        txtPlayerName = findViewById(R.id.txtSummaryPlayerId);
        Snackbar.make(findViewById(R.id.layoutMain_id), "Select a Name to view player profile.", Snackbar.LENGTH_LONG).show();

        getProfiles();
        myActiveID();
    }

    public void myActiveID(){
        txtPlayerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerID = view.getResources().getResourceName(view.getId());
            }
        });
        System.out.println("Clicked Name: " + txtPlayerName.getText().toString());
        playerNameClickListener();
    }

    public void playerNameClickListener(){
        txtPlayerName.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PlayerDetails.class)));
        Log.d(LOG_TAG, "Clicked Text ID>>><< " + R.id.txtSummaryPlayerId);
    }

    private void getProfiles(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/godwinBime/6eca1d76b619142a2b76c8631f7ce772/raw/75295c5eefaaee7962371108bb272468ab64a5ad/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<PlayerProfile>> call = jsonPlaceHolderAPI.getPlayersProfile();

        call.enqueue(new Callback<List<PlayerProfile>>() {
            @Override
            public void onResponse(Call<List<PlayerProfile>> call, Response<List<PlayerProfile>> response) {
                if (!response.isSuccessful()){
                    txtPlayerName.setText("Code: " + response.code());
                    return;
                }
                List<PlayerProfile> playerProfiles = response.body();
                for (PlayerProfile playerProfile : playerProfiles){
                    String content = "";
                    content = playerProfile.getSummaryPlayerName() + "\n\n";

                    txtPlayerName.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PlayerProfile>> call, Throwable t) {
                txtPlayerName.setText(t.getMessage());
            }
        });

    }
}