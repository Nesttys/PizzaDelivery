package com.example.pizzadelivery.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.pizzadelivery.model.Stocks;
import com.example.pizzadelivery.adapters.StocksAdapter;

import java.util.ArrayList;
import java.util.List;

public class StocksFragment extends Fragment {

    private RecyclerView recyclerView;

    public StocksFragment() {

    }

    public static StocksFragment newInstance() {
        return new StocksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        List<Stocks> stocksList = new ArrayList<>();
        stocksList.add(new Stocks("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла"));
        stocksList.add(new Stocks("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла"));
        stocksList.add(new Stocks("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла"));
        stocksList.add(new Stocks("http://i.imgur.com/DvpvklR.png", "Пеперони", "Моцарелла"));

        View view = inflater.inflate(R.layout.stocks_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_stocks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new StocksAdapter(stocksList));

        return view;
    }


}