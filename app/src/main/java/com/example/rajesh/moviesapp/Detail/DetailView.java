package com.example.rajesh.moviesapp.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rajesh.moviesapp.PojoClasses.NowshowingPoJo;
import com.example.rajesh.moviesapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class DetailView extends Fragment {

    ImageView im;
    String url;
    ProgressBar pbb;
    NowshowingPoJo.ResultsBean android;
    public DetailView(NowshowingPoJo.ResultsBean resultsBean) {
        this.android=resultsBean;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        im=(ImageView)view.findViewById(R.id.poster);

        TextView tit=(TextView)view.findViewById(R.id.title);

        TextView date=(TextView)view.findViewById(R.id.release_date);
        TextView rate=(TextView)view.findViewById(R.id.rating);

        TextView ov=(TextView)view.findViewById(R.id.synopsis);
// tv.setText(""+datas.getOverview());
        tit.setText(""+android.getTitle());
        //vote.setText(""+datas.getVote_count());
        date.setText(""+android.getRelease_date());
        rate.setText(""+android.getVote_average());
        //lag.setText(""+datas.getOriginal_language());
        ov.setText(""+android.getOverview());
        url = "http://image.tmdb.org/t/p/w342/" +android.getPoster_path();


        ViewCompat.setTransitionName(im,url);

        //Log.e("<><><><><>",""+url);
        Picasso.with(getActivity())
                .load(url)
                .into(im, new Callback() {
                    @Override
                    public void onSuccess() {
                        //pbb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
      //  FloatingActionButton f=(FloatingActionButton) view.findViewById(R.id.fab_fav);
im.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});



        return view;


    }
}

