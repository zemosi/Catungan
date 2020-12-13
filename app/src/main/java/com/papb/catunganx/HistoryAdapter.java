package com.papb.catunganx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    private Context context;
    private ArrayList<History> values;
    private LayoutInflater inflater;

    public HistoryAdapter(Context context, ArrayList<History> values) {
        this.context = context;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_list, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        final History data = values.get(position);
        holder.txtMethod.setText(data.getMethod());
        holder.moneyAmount.setText(data.getAmount());
        holder.txtDate.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtMethod;
        TextView moneyAmount;
        TextView txtDate;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            txtMethod = itemView.findViewById(R.id.text_method);
            moneyAmount = itemView.findViewById(R.id.money_amount);
            txtDate = itemView.findViewById(R.id.text_date);
        }
    }
}
