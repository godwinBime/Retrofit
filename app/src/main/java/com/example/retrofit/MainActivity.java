package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private CircleImageView imgProfilePicture;
    private TextView txtPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgProfilePicture = findViewById(R.id.imgSummaryPlayerProfilePictureID);
        txtPlayerName = findViewById(R.id.txtSummaryPlayerId);
        Snackbar.make(findViewById(R.id.layoutMain_id), "Select an image to view player profile.", Snackbar.LENGTH_LONG).show();
        imageClickListener();
    }

    public void imageClickListener(){
        imgProfilePicture.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PlayerDetails.class)));
    }
}