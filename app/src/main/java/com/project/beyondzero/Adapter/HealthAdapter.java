package com.project.beyondzero.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.beyondzero.Model.InsuaranceModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {

    Context context;
    ArrayList<InsuaranceModel>list;

    public HealthAdapter(Context context, ArrayList<InsuaranceModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HealthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.health_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.ViewHolder holder, int position) {
        holder.number.setText(list.get(position).getPatNo());
        holder.name.setText(list.get(position).getPatName());
        holder.Id.setText(list.get(position).getPatId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, number,Id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.member_no);
            Id = itemView.findViewById(R.id.id_no);

        }
    }
}
