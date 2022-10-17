package com.project.beyondzero.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.Activites.CreateAppointment1;
import com.project.beyondzero.Activites.CreateAppointmentActivity;
import com.project.beyondzero.Model.DoctorsModel1;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class DoctorsAdapter1 extends RecyclerView.Adapter<DoctorsAdapter1.ViewHolder> {


    public DoctorsAdapter1(Context context, ArrayList<DoctorsModel1> list, CreateAppointmentActivity createAppointmentActivity) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<DoctorsModel1>list;


    @NonNull
    @Override
    public DoctorsAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item_card, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.title_image.setImageResource(list.get(position).getTitle_image());
        holder.time.setText(list.get(position).getTime());
        holder.name.setText(list.get(position).getName());
        holder.title.setText(list.get(position).getTitle());
        holder.patients.setText(list.get(position).getPatients());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreateAppointment1.class);
                intent.putExtra("image",list.get(position).getImage());
                intent.putExtra("time",list.get(position).getTime());
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("patients",list.get(position).getPatients());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });



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
