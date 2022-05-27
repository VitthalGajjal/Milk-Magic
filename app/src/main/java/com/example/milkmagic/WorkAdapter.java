package com.example.milkmagic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkmagic.Customer;
import com.example.milkmagic.R;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<com.example.milkmagic.WorkAdapter.WorkViewHolder> {
    List<Work> Work_list;
    Context wcontext;

    public WorkAdapter(Context wcontext, List<Work> Work_list) {
        this.wcontext = wcontext;
        this.Work_list = Work_list;
    }

    @NonNull
    @Override
    public com.example.milkmagic.WorkAdapter.WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new com.example.milkmagic.WorkAdapter.WorkViewHolder(inflater.inflate(R.layout.singleworkinfo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.milkmagic.WorkAdapter.WorkViewHolder holder, int position) {
        holder.tv_name.setText(Work_list.get(position).getWork_name());
        holder.tv_type.setText(Work_list.get(position).getWork_type());
        holder.tv_date.setText(Work_list.get(position).getWork_date());
        holder.tv_fat.setText(Work_list.get(position).getWork_fat());
        holder.tv_srf.setText(Work_list.get(position).getWork_srf());
        holder.tv_quantity.setText(Work_list.get(position).getWork_quantity());
        holder.tv_total.setText(Work_list.get(position).getWork_total());

    }

    @Override
    public int getItemCount() {
        return Work_list.size();
    }


    public class WorkViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_type,tv_date,tv_fat,tv_srf,tv_quantity,tv_total;
        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_type = itemView.findViewById(R.id.tv_type);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_fat = itemView.findViewById(R.id.tv_fat);
            tv_srf = itemView.findViewById(R.id.tv_srf);
            tv_quantity = itemView.findViewById(R.id.tv_quantity);
            tv_total = itemView.findViewById(R.id.tv_total);

        }
    }
}