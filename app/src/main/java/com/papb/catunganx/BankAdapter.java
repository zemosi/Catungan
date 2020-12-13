package com.papb.catunganx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>{

    private Context context;
    private ArrayList<Bank> values;
    private LayoutInflater inflater;

    public BankAdapter(Context context, ArrayList<Bank> values) {
        this.context = context;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bank_list, parent, false);
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
        final Bank data = values.get(position);
        holder.bankName.setText(data.getBankName());
        holder.total.setText(data.getTotal());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class BankViewHolder extends RecyclerView.ViewHolder {
        TextView bankName;
        TextView total;

        public BankViewHolder(View itemView) {
            super(itemView);
            bankName = itemView.findViewById(R.id.bank_name);
            total = itemView.findViewById(R.id.bank_amount);
        }
    }
}
