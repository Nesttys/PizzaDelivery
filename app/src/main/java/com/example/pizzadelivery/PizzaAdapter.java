package com.example.pizzadelivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzadelivery.Model.Pizza;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {

    List<Pizza> pizzaList;

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.myapplication.R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(pizzaList.get(position).getPhotoId()).into(holder.image);
        holder.name.setText(pizzaList.get(position).getName());
        holder.components.setText(pizzaList.get(position).getComponents());
        holder.price.setText("от "+ pizzaList.get(position).getPrice() + " грн");
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(com.example.myapplication.R.id.pizza_photo);
            name = itemView.findViewById(com.example.myapplication.R.id.pizza_name);
            components = itemView.findViewById(com.example.myapplication.R.id.pizza_components);
            price = itemView.findViewById(com.example.myapplication.R.id.pizza_price);
        }
    }

}
