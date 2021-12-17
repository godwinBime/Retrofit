package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<String> profileNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> profileNames, ArrayList<String> mImages){
        this.profileNames = profileNames;
        this.mImages = mImages;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_player_profile, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.circleImageView);
        holder.profileName.setText(profileNames.get(position));
    }

    @Override
    public int getItemCount() {
        return profileNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView profileName;
        RelativeLayout parentRelativeLayout;

        public ViewHolder(View itemView){
            super(itemView);
            circleImageView = itemView.findViewById(R.id.imgSummaryPlayerProfilePictureID);
            profileName = itemView.findViewById(R.id.txtSummaryPlayerId);
        }
    }
}
