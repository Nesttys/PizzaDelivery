package com.example.pizzadelivery.adapters;

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
import com.example.pizzadelivery.model.Order;
import com.example.pizzadelivery.model.Pizza;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder>
        implements RadioGroup.OnCheckedChangeListener {

    private List<Pizza> pizzaList;
    private StringBuilder str ;
    private TextView tvWeight;
    private TextView tvPrice;
    private TextView tvIngridients;
    private TextView tvNameOfpizza;
    DatabaseReference myRef;
    private RadioGroup rg1;
    private RadioGroup rg2;
    Order order;
    private Email email;

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(com.example.myapplication.R.layout.card_view,parent,false);
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

                str = new StringBuilder();
                order = new Order();
                myRef = FirebaseDatabase.getInstance().getReference().child("Order");

                tvWeight = view.findViewById(R.id.tvWeight);
                tvPrice = view.findViewById(R.id.tvPrice);
                tvNameOfpizza = view.findViewById(R.id.nameofpizza);
                tvIngridients = view.findViewById(R.id.ingridientsofpizza);

                rg1 =view.findViewById(R.id.radioGroup);
                rg1.setOnCheckedChangeListener(PizzaAdapter.this);

                rg2 = view.findViewById(R.id.radioGroup2);
                rg2.setOnCheckedChangeListener(PizzaAdapter.this);

                tvNameOfpizza.setText(pizzaList.get(position).getName());
                tvIngridients.setText(pizzaList.get(position).getComponents());

                Button btSendemail = view.findViewById(R.id.btsendemail);

                btSendemail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order.setOrder(str.toString().trim());

                        myRef.push().setValue(order);



//                        email = new Email();
//                        email.sendMail(str.toString());

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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rdsmall:
                tvWeight.setText("500g");
                tvPrice.setText("88grn");
                str.append("Small pizza 500g 88grn");
                break;
            case R.id.rdmedium:
                tvWeight.setText("600g");
                tvPrice.setText("165grn");
                str.append("Medium pizza, 600g, 165grn");
                break;

            case R.id.rdlarge:
                tvWeight.setText("700g");
                tvPrice.setText("200grn");
                str.append("Large pizza, 800, 200grn");
                break;

            case R.id.rdstandart:
                str.append(" Standart pizza");
                break;

            case R.id.rdthin:
                str.append(" Thin pizza");
                break;

            case R.id.rdhotdog:
                str.append(" Hot-dog pizza");
                break;

            default:
                str.append("skdjfsdkplf");
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView components;
        TextView price;
        Button order;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(com.example.myapplication.R.id.pizza_photo);
            name = itemView.findViewById(com.example.myapplication.R.id.pizza_name);
            components = itemView.findViewById(com.example.myapplication.R.id.pizza_components);
            price = itemView.findViewById(com.example.myapplication.R.id.pizza_price);
            order = itemView.findViewById(R.id.order);
        }
    }

}
