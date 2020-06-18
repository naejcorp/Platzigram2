package com.example.platzigram.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platzigram.R;
import com.example.platzigram.model.Picture;


import java.util.ArrayList;

 public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<com.example.platzigram.model.Picture> pictures;
    private  int resourse;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<com.example.platzigram.model.Picture> pictures, int resourse, Activity activity) {
        this.pictures = pictures;
        this.resourse = resourse;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {

        Picture picture=pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());


    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCard = itemView.findViewById(R.id.pictureCard);
            usernameCard = itemView.findViewById(R.id.userNameCard);
            timeCard = itemView.findViewById(R.id.timeCard);
            likeNumberCard = itemView.findViewById(R.id.likeNumberCard);

        }
    }

}
