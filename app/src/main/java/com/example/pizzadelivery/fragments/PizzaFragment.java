package com.example.pizzadelivery.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzadelivery.model.Pizza;
import com.example.pizzadelivery.adapters.PizzaAdapter;
import com.example.pizzadelivery.R;

import java.util.ArrayList;
import java.util.List;

public class PizzaFragment extends Fragment {

    private RecyclerView recyclerView;

    public static PizzaFragment newInstance() {
        return new PizzaFragment();
    }


    public PizzaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9F%D0%B5%D0%BF%D0%BF%D0%B5%D1%80%D0%BE%D0%BD%D0%B8_300dpi-min-thumbnail-960x960-70.jpg", "Пепперони", "Моцарелла, Салями, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9A%D0%B0%D1%80%D0%B1%D0%BE%D0%BD%D0%B0%D1%80%D0%B0_300dpi-min-thumbnail-960x960-70.jpg", "Карбонара", "Лук, Бекон, Ветчина, Грибы, Моцарелла, Соус ", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9C%D0%B0%D1%80%D0%B3%D0%B0%D1%80%D0%B8%D1%82%D0%B0_300dpi-min-thumbnail-960x960-70.jpg", "Маргарита", "Моцарелла, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9F%D1%8F%D1%82%D1%8C_%D1%81%D1%8B%D1%80%D0%BE%D0%B2_300dpi-min-thumbnail-960x960-70.jpg", "4 Сыра", "Моцарелла, Чеддер, Бергадер Блю, Пармезан", 88));

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_pizza);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new PizzaAdapter(pizzaList));

        return view;
    }
}
