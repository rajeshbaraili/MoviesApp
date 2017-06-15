package com.example.rajesh.moviesapp.ActivityClasses;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rajesh.moviesapp.R;
import com.example.rajesh.moviesapp.Tabs.TV.AiringtodayFragment;
import com.example.rajesh.moviesapp.Tabs.TV.NowPlayingFragment;
import com.example.rajesh.moviesapp.Tabs.TV.PpularFragment;
import com.example.rajesh.moviesapp.Tabs.TV.TopratedTv;

import java.util.ArrayList;
import java.util.List;

public class TvFragment extends Fragment {
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_ma, container, false);


        viewPager = (ViewPager)view.findViewById(R.id.view);
        setupViewPager(viewPager);
        TabLayout  tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        TvFragment.ViewPagerAdapter adapter = new TvFragment.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new PpularFragment(), "Popular TV shows");
        adapter.addFrag(new TopratedTv(), "Top rated TV shows");
        adapter.addFrag(new NowPlayingFragment(), "On the air TV");
        adapter.addFrag(new AiringtodayFragment(), "Airing today");

        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String>  mFragmentTitleList = new ArrayList<>();
        // DataAdapter adapter=new DataAdapter(mFragmentTitleList);
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }



        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }}




}
