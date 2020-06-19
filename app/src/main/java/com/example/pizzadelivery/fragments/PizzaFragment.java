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
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9F%D0%B5%D0%BF%D0%BF%D0%B5%D1%80%D0%BE%D0%BD%D0%B8_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Тони Пепперони", "Моцарелла, Салями, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9A%D0%B0%D1%80%D0%B1%D0%BE%D0%BD%D0%B0%D1%80%D0%B0_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Карбонара", "Лук, Бекон, Ветчина, Грибы, Моцарелла, Соус Альфредо", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9C%D0%B0%D1%80%D0%B3%D0%B0%D1%80%D0%B8%D1%82%D0%B0_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Маргарита", "Моцарелла, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9F%D1%8F%D1%82%D1%8C_%D1%81%D1%8B%D1%80%D0%BE%D0%B2_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Пять Сыров", "Фета, Пармезан, Бергадер Блю, Моцарелла, Соус Альфредо, Чеддер", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_mobile/2018/02/28/%D0%9F%D0%B5%D0%BF%D0%BF%D0%B5%D1%80%D0%BE%D0%BD%D0%B8_%D0%91%D0%BB%D1%8E%D0%B7_300dpi-thumbnail-960x960-70.jpg",
                "Пицца Пепперони Блюз", "Бергадер Блю, Моцарелла, Пепперони, Соус Альфредо", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_mobile/2018/02/22/BBQ-thumbnail-960x960-70.jpg",
                "Пицца Барбекю", "Курица, Лук, Бекон, Грибы, Моцарелла, Соус Барбекю", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9A%D0%B0%D0%BD%D1%82%D1%80%D0%B8_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Кантри", "Лук, Бекон, Ветчина, Грибы, Моцарелла, Огурцы маринованные, Соус Чесночный", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9C%D1%8E%D0%BD%D1%85%D0%B5%D0%BD%D1%81%D0%BA%D0%B0%D1%8F_DeLUX_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Мюнхенская DeLUX", "Ветчина, Горчица, Колбаски баварские, Моцарелла, Помидоры, Сосиски белые, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/03/%D0%A1%D0%BF%D0%B0%D0%B9%D1%81%D0%B8_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца Спайси", "Халапеньо, Бекон, Моцарелла, Пепперони, Помидоры, Соус Domino's", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/04/%D0%9C%D0%B8%D1%86%D1%86%D0%B0_300dpi-min-thumbnail-960x960-70.jpg",
                "Пицца МитZZа", "Пармезан, Бекон, Ветчина, Колбаски баварские, Моцарелла, Пепперони, Соус Domino's", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/03/Royal_Slice_retoch-min-min-thumbnail-960x960-70.jpg",
                "Пицца Роял Чизбургер", "Двойная порция стейк-мяса (говядина), Поливка (соус Burger), Лук, Моцарелла, Соус", 88));
        pizzaList.add(new Pizza("https://media.dominos.ua/__sized__/menu/product_osg_image_category/2019/10/03/SalmonPhill-slicere-made-web-min-min-thumbnail-960x960-70.jpg",
                "Пицца Лосось Филадельфия", "Крем-сыр Филадельфия, Лосось, Моцарелла, Соус Альфредо", 88));

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_pizza);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new PizzaAdapter(pizzaList));

        return view;
    }
}
