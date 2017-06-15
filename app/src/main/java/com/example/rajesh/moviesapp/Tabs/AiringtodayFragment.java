package com.example.rajesh.moviesapp.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rajesh.moviesapp.Adapter.DataAdapter;
import com.example.rajesh.moviesapp.Network.RestClient;
import com.example.rajesh.moviesapp.PojoClasses.NowshowingPoJo;
import com.example.rajesh.moviesapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AiringtodayFragment extends Fragment {


    RecyclerView recyclerView;
    String nowplaying;
    LinearLayoutManager linearLayoutManager;

    ArrayList<NowshowingPoJo.ResultsBean> data;
    int position;
    DataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_airingtoday, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.movies_recycler_viewtv);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        nowplaying = "on_the_air";






        Call<NowshowingPoJo> call = RestClient.get().getontv(nowplaying);
        call.enqueue(new Callback<NowshowingPoJo>() {
            @Override
            public void onResponse(Call<NowshowingPoJo> call, Response<NowshowingPoJo> response) {
                NowshowingPoJo jsonResponse = response.body();

                try{
                    data = new ArrayList(jsonResponse.getResults());

                    adapter.setAndroid(data);
                    recyclerView.setAdapter(adapter);
                    recyclerView.notify();

                }catch (Exception e){

                }



            }

            @Override
            public void onFailure(Call<NowshowingPoJo> call, Throwable t) {

            }
        });
         return view;
    }

}
