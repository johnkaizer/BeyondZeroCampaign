package com.project.beyondzero.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.Fragments.HomeFragment;
import com.project.beyondzero.Model.NewsFeedModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    public NewsFeedAdapter(Context context, ArrayList<NewsFeedModel> list, HomeFragment homeFragment) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<NewsFeedModel> list;

    @NonNull
    @Override
    public NewsFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.date.setText(list.get(position).getDate());
        holder.header.setText(list.get(position).getHeader());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView date, header;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image = itemView.findViewById(R.id.imageView6);
            date = itemView.findViewById(R.id.date);
            header = itemView.findViewById(R.id.header1);
        }
    }
}
