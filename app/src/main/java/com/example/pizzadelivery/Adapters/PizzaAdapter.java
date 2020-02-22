package com.example.pizzadelivery.Adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.pizzadelivery.Email;
import com.example.pizzadelivery.Model.Pizza;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    List<Pizza> pizzaList;
    StringBuilder str ;
    TextView tvWeight;
    TextView tvPrice;
    String to = "raxiplay283@gmail.com";
    String subject = "Pizza order";
    Email email;
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        str = new StringBuilder();
        Picasso.get().load(pizzaList.get(position).getPhotoId()).into(holder.image);
        holder.name.setText(pizzaList.get(position).getName());
        holder.components.setText(pizzaList.get(position).getComponents());
        holder.price.setText("от "+ pizzaList.get(position).getPrice() + " грн");
        holder.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(holder.itemView.getContext());
                View view = inflater.inflate(R.layout.pizza_dialog,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext())
                        .setView(view);

//                RadioButton btsmall = view.findViewById(R.id.rdsmall);
//                RadioButton btmedium = view.findViewById(R.id.rdmedium);
//                RadioButton btlarge = view.findViewById(R.id.rdlarge);
//                RadioButton btstandart = view.findViewById(R.id.rdstandart);
//                RadioButton btthin = view.findViewById(R.id.rdthin);
//                RadioButton bthotdog = view.findViewById(R.id.rdhotdog);
                tvWeight = view.findViewById(R.id.tvWeight);
                tvPrice = view.findViewById(R.id.tvPrice);
                Button btSendemail = view.findViewById(R.id.btsendemail);
                btSendemail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        email = new Email();

                        email.sendMail(to,subject,"pizza");;
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rdsmall:
                tvWeight.setText("500g");
                tvPrice.setText("88");
                str.append("Small pizza 500g 88grn");
            case R.id.rdmedium:
                tvWeight.setText("500g");
                tvPrice.setText("165");
                str.append("Medium pizza");
            case R.id.rdlarge:
                tvWeight.setText("500g");
                tvPrice.setText("200");
                str.append("Large pizza");

            case R.id.rdstandart:
                str.append(" Standart pizza");
            case R.id.rdthin:
                str.append(" Thin pizza");
            case R.id.rdhotdog:
                str.append(" Hot-dog pizza");

            default:
                str.append("skdjfsdkplf");
        }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        TextView price;
        Button order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(com.example.myapplication.R.id.pizza_photo);
            name = itemView.findViewById(com.example.myapplication.R.id.pizza_name);
            components = itemView.findViewById(com.example.myapplication.R.id.pizza_components);
            price = itemView.findViewById(com.example.myapplication.R.id.pizza_price);
            order = itemView.findViewById(R.id.order);
        }
    }

}
