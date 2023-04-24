package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemon.fragments.FragmentCreate;
import com.example.lutemon.fragments.FragmentFight;
import com.example.lutemon.fragments.FragmentHome;
import com.example.lutemon.fragments.FragmentTrain;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentStateAdapter{

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentCreate();
            case 1:
                return new FragmentHome();
            case 2:
                return new FragmentTrain();
            case 3:
                return new FragmentFight();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}