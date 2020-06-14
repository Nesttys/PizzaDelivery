package com.example.pizzadelivery.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.pizzadelivery.adapters.DrinksAdapter;
import com.example.pizzadelivery.model.Drinks;

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
        drinksList.add(new Drinks("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/09/04/Pepsi_05L_Blue-thumbnail-960x960.png", "Pepsi", "500мл"));
        drinksList.add(new Drinks("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/09/04/Pepsi_05L_BlackMAX-thumbnail-960x960.png", "Pepsi Max", "500мл"));
        drinksList.add(new Drinks("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2020/03/04/Pepsi_05L_Mango_new-min-thumbnail-960x960.png", "Pepsi Манго", "500мл"));
        drinksList.add(new Drinks("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/09/04/Aqua_Minerale_05_gaz-thumbnail-960x960.png", "Aqua Minerale", "500 мл"));

        View view = inflater.inflate(R.layout.drinks_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_drinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new DrinksAdapter(drinksList));

        return view;
    }
}
