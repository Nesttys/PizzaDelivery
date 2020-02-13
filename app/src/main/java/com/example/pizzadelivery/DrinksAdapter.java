package com.example.pizzadelivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.pizzadelivery.Model.Drinks;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinksAdapter  extends RecyclerView.Adapter<DrinksAdapter.MyViewHolder>{

    List<Drinks> drinksList;

    public DrinksAdapter(List<Drinks> drinksList) { this.drinksList = drinksList; }

    @NonNull
    @Override
    public DrinksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.myapplication.R.layout.card_view,parent,false);
        return new DrinksAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(drinksList.get(position).getPhotoId()).into(holder.image);
        holder.name.setText(drinksList.get(position).getName());
        holder.components.setText(drinksList.get(position).getComponents());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        Button order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(com.example.myapplication.R.id.pizza_photo);
            name = itemView.findViewById(com.example.myapplication.R.id.pizza_name);
            components = itemView.findViewById(com.example.myapplication.R.id.pizza_components);
            order = itemView.findViewById(R.id.order);
            order.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() { return drinksList.size(); }
}
