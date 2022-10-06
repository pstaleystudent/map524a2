package com.example.a2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductListAdapter extends BaseAdapter {
    private final Context context;
    public ProductListAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        if (ProductList.getInstance().get() != null)
            return ProductList.getInstance().get().size();
        return 0; //not sure why this fires on boot
    }
    @Override
    public Object getItem(int i) {
        return ProductList.getInstanceValue(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_list_view_products, parent, false);
        ProductEntry p = (ProductEntry) getItem(position);
        TextView vName = (TextView) convertView.findViewById(R.id.nameText);
        TextView vQuantity = (TextView) convertView.findViewById(R.id.quantityText);
        TextView vPrice = (TextView) convertView.findViewById(R.id.priceText);
        vName.setText(p.getName());
        vQuantity.setText(Integer.toString(p.getQuantity()));
        vPrice.setText(Double.toString(p.getPrice()));
        return convertView;

    }
}
