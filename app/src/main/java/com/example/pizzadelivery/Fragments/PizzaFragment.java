package com.example.pizzadelivery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzadelivery.Model.Pizza;
import com.example.pizzadelivery.Adapters.PizzaAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PizzaFragment extends Fragment {

    RecyclerView recyclerView;

    public static PizzaFragment newInstance() {
        PizzaFragment fragment = new PizzaFragment();
        return fragment;
    }


    public PizzaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("http://kulinarnia.ru/wp-content/uploads/2015/03/recept-nastoiashchei-italianskoi-pitctcy-margarita.jpg", "Пеперони", "Моцарелла, Салями", 120));
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "Американа", "Моцарелла, Салями, Оливки", 130));
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "Маргарита", "Моцарелла, Салями, A", 140));
        pizzaList.add(new Pizza("https://www.djurenko.com/wp-content/uploads/2011/10/pizza-4formaggi_09.jpg", "4 Сыра", "Моцарелла, Салями, B", 150));

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_pizza);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new PizzaAdapter(pizzaList));

        return view;
    }
}
