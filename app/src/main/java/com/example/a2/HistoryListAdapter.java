package com.example.a2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    HistoryListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_list_view_products, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryEntry he = HistoryList.getInstanceValue(position);
        holder.vName.setText(he.getName());
        holder.vQuantity.setText(String.format("%d",he.getQuantity()));
        holder.vPrice.setText(String.format("%.2f",he.getPrice()));
    }
    @Override
    public int getItemCount() {
        return HistoryList.getInstance().get().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView vName;
        TextView vQuantity;
        TextView vPrice;
        ViewHolder(View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.nameText);
            vQuantity = (TextView) itemView.findViewById(R.id.quantityText);
            vPrice = (TextView) itemView.findViewById(R.id.priceText);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}