package com.example.pizzadelivery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.pizzadelivery.Adapters.DrinksAdapter;
import com.example.pizzadelivery.Model.Drinks;

import java.util.ArrayList;
import java.util.List;

public class DrinksFragment extends Fragment {
    RecyclerView recyclerView;

    public static DrinksFragment newInstance() {
        return new DrinksFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Drinks> drinksList = new ArrayList<>();
        drinksList.add(new Drinks("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла, Салями"));
        drinksList.add(new Drinks("http://i.imgur.com/DvpvklR.png", "Американа", "Моцарелла, Салями, Оливки"));
        drinksList.add(new Drinks("http://i.imgur.com/DvpvklR.png", "Маргарита", "Моцарелла, Салями, A"));
        drinksList.add(new Drinks("http://i.imgur.com/DvpvklR.png", "4 Сыра", "Моцарелла, Салями, B"));

        View view = inflater.inflate(R.layout.drinks_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_drinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new DrinksAdapter(drinksList));

        return view;
    }
}
