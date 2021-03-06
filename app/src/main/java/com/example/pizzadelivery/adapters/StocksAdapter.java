package com.example.pizzadelivery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzadelivery.R;
import com.example.pizzadelivery.model.Stocks;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.MyViewHolder> {
    List<Stocks> stocksList;

    public StocksAdapter(List<Stocks> stocksList) {
        this.stocksList = stocksList;
    }

    @NonNull
    @Override
    public StocksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.pizzadelivery.R.layout.card_view,parent,false);
        return new StocksAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(stocksList.get(position).getPhotoId()).into(holder.image);
        holder.name.setText(stocksList.get(position).getName());
        holder.components.setText(stocksList.get(position).getComponents());
    }

    @Override
    public int getItemCount() { return stocksList.size(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        Button order;
        TextView price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(com.example.pizzadelivery.R.id.pizza_photo);
            name = itemView.findViewById(com.example.pizzadelivery.R.id.pizza_name);
            components = itemView.findViewById(com.example.pizzadelivery.R.id.pizza_components);
            price = itemView.findViewById(R.id.pizza_price);
            order = itemView.findViewById(R.id.order);
            order.setVisibility(View.GONE);
            price.setVisibility(View.GONE);
        }
    }
}
