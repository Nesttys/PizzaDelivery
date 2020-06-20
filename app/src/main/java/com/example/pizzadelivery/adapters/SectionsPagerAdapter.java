package com.example.pizzadelivery.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pizzadelivery.fragments.DrinksFragment;
import com.example.pizzadelivery.fragments.PizzaFragment;
import com.example.pizzadelivery.fragments.MapViewFragment;
import com.example.pizzadelivery.R;
import com.example.pizzadelivery.fragments.PlaceholderFragment;
import com.example.pizzadelivery.fragments.StocksFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return StocksFragment.newInstance();

            case 1:
                return PizzaFragment.newInstance();

            case 2:
                return DrinksFragment.newInstance();

            case 3:
                return MapViewFragment.getInstance();

            default:
                return PlaceholderFragment.newInstance(5);

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}