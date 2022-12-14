package com.project.beyondzero.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.ViewHolder> {


    Context context;
    ArrayList<AppointmentsModel>list;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);

    }
    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener =clickListener;
    }

    public AppointmentsAdapter(Context context, ArrayList<AppointmentsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AppointmentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item, parent, false);
        return new ViewHolder(v,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(list.get(position).getDoctorName());
        holder.date.setText(list.get(position).getAppointmentDate());
        holder.time.setText(list.get(position).getAppointmentTime());
        holder.title.setText(list.get(position).getDoctorTitle());
        holder.phone.setText(list.get(position).getDoctorPhone());
        holder.flow_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(list.get(position).getDoctorPhone())));
                context.startActivity(intent);

            }
        });
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, date, time, title,phone;
        ImageButton flow_menu;
        AppCompatButton cancel;
        public ViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);

            name = itemView.findViewById(R.id.doc_name);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);
            phone = itemView.findViewById(R.id.doc_phone);
            flow_menu = itemView.findViewById(R.id.flow_menu);
            cancel = itemView.findViewById(R.id.cancel_btn);
        }
    }
}
