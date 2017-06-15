package com.example.rajesh.moviesapp.Tabs.Movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
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


public class Popular   extends Fragment {
    RecyclerView recyclerView;
    String nowplaying;
    LinearLayoutManager linearLayoutManager;

    ArrayList<NowshowingPoJo.ResultsBean> data;
    int position;
    DataAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new DataAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.movies_recycler_view);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);








        Call<NowshowingPoJo> call = RestClient.get().getJSON("movie","popular");
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

        return  view;
    }

}

