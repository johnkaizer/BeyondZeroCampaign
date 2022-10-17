package com.project.beyondzero.Adapter;

import static com.project.beyondzero.DBmain.TABLENAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.Activites.CreateAppointment1;
import com.project.beyondzero.DBmain;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.ViewHolder> {


    Context context;
    ArrayList<AppointmentsModel>list;
    SQLiteDatabase sqLiteDatabase;
    int appointment_item;

    public AppointmentsAdapter(Context context, ArrayList<AppointmentsModel> list, SQLiteDatabase sqLiteDatabase, int appointment_item) {
        this.context = context;
        this.list = list;
        this.sqLiteDatabase = sqLiteDatabase;
        this.appointment_item = appointment_item;
    }

    @NonNull
    @Override
    public AppointmentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final  AppointmentsModel appointmentsModel = list.get(position);
        byte[]image = appointmentsModel.getAvatar();
        Bitmap bitmap= BitmapFactory.decodeByteArray(image,0,image.length);
        holder.image.setImageBitmap(bitmap);
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());
        holder.title.setText(list.get(position).getTitle());
        holder.flow_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.flow_menu);
                popupMenu.inflate(R.menu.flow_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.edit_menu:

                                Bundle bundle = new Bundle();
                                bundle.putInt("id",appointmentsModel.getId());
                                bundle.putByteArray("avatar",appointmentsModel.getAvatar());
                                bundle.putString("name",appointmentsModel.getName());
                                bundle.putString("date",appointmentsModel.getDate());
                                bundle.putString("time",appointmentsModel.getTime());
                                bundle.putString("title",appointmentsModel.getTitle());
                                bundle.putString("patient",appointmentsModel.getPatient());
                                bundle.putInt("phone",appointmentsModel.getPhone());
                                Intent intent = new Intent(context, CreateAppointment1.class);
                                intent.putExtra("appointmentData",bundle);
                                context.startActivity(intent);

                                break;
                            case  R.id.delete_menu:

                                DBmain dBmain= new DBmain(context);
                                sqLiteDatabase= dBmain.getReadableDatabase();
                                long recdelete = sqLiteDatabase.delete(TABLENAME, "id="+appointmentsModel.getId(),null);
                                if (recdelete!= -1){
                                    Toast.makeText(context,"Appointment successfully deleted",Toast.LENGTH_SHORT).show();
                                    list.remove(position);
                                    notifyDataSetChanged();

                                }

                                break;
                            default:
                                return false;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, date, time, title;
        ImageButton flow_menu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image =itemView.findViewById(R.id.imageView8);
            name = itemView.findViewById(R.id.doc_name);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);
            flow_menu = itemView.findViewById(R.id.flow_menu);
        }
    }
}
