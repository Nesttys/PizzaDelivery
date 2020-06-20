package com.example.pizzadelivery.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzadelivery.R;
import com.example.pizzadelivery.model.Order;
import com.example.pizzadelivery.model.Pizza;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder>
        implements RadioGroup.OnCheckedChangeListener {

    private List<Pizza> pizzaList;
    private StringBuilder size ;
    private StringBuilder bortiki ;
    private StringBuilder phone ;

    private TextView tvWeight;
    private TextView tvPrice;
    private TextView tvIngridients;
    private TextView tvNameOfpizza;
    private EditText etPhone;
    private int weight = 500;
    private boolean isThin = false;
    DatabaseReference myRef;
    private RadioGroup rg1;
    private RadioGroup rg2;
    Order order;

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(com.example.pizzadelivery.R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
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

                size = new StringBuilder();
                bortiki = new StringBuilder();
                phone = new StringBuilder();
                order = new Order();
                myRef = FirebaseDatabase.getInstance().getReference().child("Order");

                tvWeight = view.findViewById(R.id.tvWeight);
                tvWeight.setText(500 + "g");
                tvPrice = view.findViewById(R.id.tvPrice);
                tvNameOfpizza = view.findViewById(R.id.nameofpizza);
                tvIngridients = view.findViewById(R.id.ingridientsofpizza);
                etPhone = view.findViewById(R.id.etPhone);
                rg1 =view.findViewById(R.id.radioGroup);
                rg1.setOnCheckedChangeListener(PizzaAdapter.this);

                rg2 = view.findViewById(R.id.radioGroup2);
                rg2.setOnCheckedChangeListener(PizzaAdapter.this);

                tvNameOfpizza.setText(pizzaList.get(position).getName());
                tvIngridients.setText(pizzaList.get(position).getComponents());

                Button btSendOrder = view.findViewById(R.id.btsendemail);
                AlertDialog dialog = builder.create();
                dialog.show();
                btSendOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order.setOrder(phone + size.toString().trim() + bortiki);

                        myRef.push().setValue(order);

                    }
                });


            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rdsmall:
                weight = 500;
                tvPrice.setText(88 + "грн");
                size.setLength(0);
                size.append(tvNameOfpizza.getText()+ " " + "Small pizza 500g 88grn ");
                break;
            case R.id.rdmedium:
                weight = 600;
                tvPrice.setText(165 + "грн");
                size.setLength(0);
                size.append(tvNameOfpizza.getText()+ " " + "Medium pizza, 165grn ");
                break;

            case R.id.rdlarge:
                weight = 800;
                tvPrice.setText(200 + "грн");
                size.setLength(0);
                size.append(tvNameOfpizza.getText() + " " + "Large pizza, 800, 200grn ");
                break;

            case R.id.rdstandart:
                isThin = false;
                bortiki.setLength(0);
                bortiki.append("Standart ");
                break;

            case R.id.rdthin:
                isThin = true;
                bortiki.setLength(0);
                bortiki.append("Thin ");
                break;

            case R.id.rdhotdog:
                isThin = false;
                bortiki.setLength(0);
                bortiki.append("Hot-dog ");
                break;

            default:
                bortiki.append("skdjfsdkplf");
                phone.append(etPhone.getText().toString());
        }
        phone.append(etPhone.getText().toString());

        tvWeight.setText((isThin ? weight - 100 : weight) + "г");
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        TextView price;
        Button order;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.pizza_photo);
            name = itemView.findViewById(R.id.pizza_name);
            components = itemView.findViewById(R.id.pizza_components);
            price = itemView.findViewById(R.id.pizza_price);
            order = itemView.findViewById(R.id.order);
            
        }
    }

}
