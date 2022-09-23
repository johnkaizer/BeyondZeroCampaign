package com.project.beyondzero.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.HomeFragment;
import com.project.beyondzero.Model.DoctorsModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {

    public DoctorsAdapter(Context context, ArrayList<DoctorsModel> list, HomeFragment homeFragment) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<DoctorsModel>list;


    @NonNull
    @Override
    public DoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item_card, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.title_image.setImageResource(list.get(position).getTitle_image());
        holder.time.setText(list.get(position).getTime());
        holder.name.setText(list.get(position).getName());
        holder.title.setText(list.get(position).getTitle());
        holder.patients.setText(list.get(position).getPatients());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image,title_image;
        TextView time, name, title,patients;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.doc_image);
            title_image = itemView.findViewById(R.id.title_image);
            time= itemView.findViewById(R.id.time_doc);
            name =  itemView.findViewById(R.id.doc_name);
            title = itemView.findViewById(R.id.title_doc);
            patients = itemView.findViewById(R.id.patient_number);
        }
    }
}
