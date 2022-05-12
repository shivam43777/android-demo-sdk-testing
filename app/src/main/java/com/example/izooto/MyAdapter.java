package com.example.izooto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        LayoutInflater inflater;
        List<News> news;

public Adapter(Context ctx, List<News> news){
        this.inflater = LayoutInflater.from(ctx);
        this.news = news;
        }




@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_custumlayoutui,parent,false);
        return new ViewHolder(view);
        }



    @Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.newsTitle.setText(news.get(position).getTitle());
        holder.newsDescription.setText(news.get(position).getDescription());
        Picasso.get.load(news.get(position).getImageUrl()).into(holder.songCoverImage);

        }

@Override
public int getItemCount() {
        return news.size();
        }

public  class ViewHolder extends  RecyclerView.ViewHolder {
    TextView newsTitle, newsDescription;
    ImageView songCoverImage;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        newsTitle = itemView.findViewById(R.id.titles);
        //   newsDescription = itemView.findViewById(R.id.);
        songCoverImage = itemView.findViewById(R.id.images);

        // handle onClick

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}}
