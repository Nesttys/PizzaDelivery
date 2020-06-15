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

import com.example.pizzadelivery.R;
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
        stocksList.add(new Stocks("https://media.dominos.ua/__sized__/promotions/promotions_image/2020/03/30/-30-crop-c0-5__0-5-2300x1352-70.jpg",
                "-30% на каждую вторую", "Обновленное супер предложение! Каждую пятницу, субботу и воскресенье покупай каждую вторую пиццу со скидкой -30%!"));
        stocksList.add(new Stocks("https://media.dominos.ua/__sized__/promotions/promotions_image/2020/03/23/119_news-crop-c0-5__0-5-2300x1352-70.jpg",
                "Большая пицца за 119.99", "Заказывай большую пиццу всего за 119,99 грн вместо 199.99 грн! "));
        stocksList.add(new Stocks("https://media.dominos.ua/__sized__/promotions/promotions_image/2020/05/28/Vtornik_news_ukr-crop-c0-5__0-5-2300x1352-70.jpg",
                "Сумасшедший вторник!", "Каждый вторник «Сумасшедший вторник» - покупай одну среднюю или большую пиццу и получай вторую со скидкой 70%!"));
        stocksList.add(new Stocks("https://media.dominos.ua/__sized__/promotions/promotions_image/2020/04/02/woweekend_news_ukr-crop-c0-5__0-5-2300x1352-70.jpg",
                "WOWeekend!", "Заказывай любую среднюю пиццу за 189 грн или большую пиццу всего за 229 грн! Акция действует каждую пятницу, субботу и воскресенье."));

        View view = inflater.inflate(R.layout.stocks_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_stocks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new StocksAdapter(stocksList));

        return view;
    }


}
