package com.example.milkmagic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
    List<Customer> customer_list;
    Context ccontext;
    DatabaseHelper db;

    public CustomerAdapter(Context ccontext, List<Customer> customer_list) {
        this.ccontext = ccontext;
        this.customer_list = customer_list;
        db = new DatabaseHelper(ccontext);
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CustomerViewHolder(inflater.inflate(R.layout.singlecustomerinfo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.tv_customername.setText(customer_list.get(position).getCustomer_name());
        holder.tv_customerphone.setText(customer_list.get(position).getCustomer_phone());
        holder.tv_customeraddress.setText(customer_list.get(position).getCustomer_address());
        holder.btn_customerdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = holder.tv_customername.getText().toString();
                boolean delete = db.detetecustomerinfo(name);
                if(delete == true){
                    Toast.makeText(ccontext.getApplicationContext(), "customerinfo deleted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ccontext.getApplicationContext(),"customerinfo not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return customer_list.size();
    }


    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView tv_customername;
        TextView tv_customerphone;
        TextView tv_customeraddress;
        Button btn_customerdelete;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_customername = itemView.findViewById(R.id.tv_customername);
            tv_customerphone = itemView.findViewById(R.id.tv_customerphone);
            tv_customeraddress = itemView.findViewById(R.id.tv_customeraddress);
            btn_customerdelete = itemView.findViewById(R.id.btn_customerdelete);


        }
    }
}
