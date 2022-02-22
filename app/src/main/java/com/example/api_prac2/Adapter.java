package com.example.api_prac2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<itemmodel> postList;

    public Adapter(Context context, List<itemmodel> postList) {
        this.context = context;
        this.postList = postList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview= LayoutInflater.from(context).inflate(R.layout.eachpost,parent,false);
        return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        itemmodel item=postList.get(position);

        holder.setImageView(item.getImageUrl());
        holder.setmlike(item.getLikes());
        holder.setMtags(item.getTags());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mlike,mtags;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
        }

        //method for fetching data

        public void setImageView(String url ){
            imageView=view.findViewById(R.id.imageview);
          Glide.with(context).load(url).into(imageView);

        }
            public void setmlike(int likes ){
            mlike=view.findViewById(R.id.mlikes);
            mlike.setText("Likes "+likes);



        }
            public void setMtags(String tags ){
            mtags=view.findViewById(R.id.mtags);
            mtags.setText("#"+tags);

        }

    }




}
