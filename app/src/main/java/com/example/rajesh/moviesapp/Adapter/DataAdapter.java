package com.example.rajesh.moviesapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.rajesh.moviesapp.Detail.DetailView;
import com.example.rajesh.moviesapp.ActivityClasses.MainActivity;
import com.example.rajesh.moviesapp.PojoClasses.NowshowingPoJo;
import com.example.rajesh.moviesapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rajesh on 6/10/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    ArrayList<NowshowingPoJo.ResultsBean> android;
    Context context;

    public DataAdapter(Context context) {
        this.context = context;


    }

    public ArrayList<NowshowingPoJo.ResultsBean> getAndroid() {
        return android;
    }

    public void setAndroid(ArrayList<NowshowingPoJo.ResultsBean> android) {
        this.android = android;
    }

    public DataAdapter(ArrayList<NowshowingPoJo.ResultsBean> data, Context contexta) {
        this.android = data;
        this.context = contexta;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder holder, final int i) {


        final String url = "http://image.tmdb.org/t/p/w342/" + android.get(i).getPoster_path();


        holder.pb.setVisibility(View.VISIBLE);
        Picasso.with(context)
                .load(url)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.pb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DetailView fragmentone = new DetailView(android.get(i));
                ((MainActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.lc, fragmentone).commit();

            }
        });


    }


    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ProgressBar pb;

        public ViewHolder(View view) {
            super(view);
            pb = (ProgressBar) view.findViewById(R.id.pb);
            imageView = (ImageView) view.findViewById(R.id.imageViewa);


        }
    }
}
