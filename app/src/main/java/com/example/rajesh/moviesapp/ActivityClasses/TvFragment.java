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
import com.example.rajesh.moviesapp.Tabs.NowPlayingFragment;
import com.example.rajesh.moviesapp.Tabs.PpularFragment;
import com.example.rajesh.moviesapp.Tabs.Toprated;

import java.util.ArrayList;
import java.util.List;

public class TvFragment extends Fragment {


    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tv2, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.viewtv);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabstv);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        TvFragment.ViewPagerAdapter adapter = new TvFragment.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new NowPlayingFragment(), "Now Playing");
        adapter.addFrag(new PpularFragment(), "Popular");
        adapter.addFrag(new Toprated(), "Airing Today");


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
