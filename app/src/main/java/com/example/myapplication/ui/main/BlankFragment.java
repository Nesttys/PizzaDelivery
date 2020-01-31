package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Pizza;
import com.example.myapplication.PizzaAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {

    RecyclerView recyclerView;

    static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла, Салями", 120));
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "Американа", "Моцарелла, Салями, Оливки", 130));
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "Маргарита", "Моцарелла, Салями, A", 140));
        pizzaList.add(new Pizza("http://i.imgur.com/DvpvklR.png", "4 Сыра", "Моцарелла, Салями, B", 150));

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_pizza);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new PizzaAdapter(pizzaList));

        return view;
    }



}
