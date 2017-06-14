package com.example.rajesh.moviesapp.Network;

import com.example.rajesh.moviesapp.PojoClasses.NowshowingPoJo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rajesh on 5/21/2017.
 */

public interface ApiCall {

    @GET("movie/{top}?api_key=dc0682a32ff56442b42d09cf9bf59c91")
    Call<NowshowingPoJo> getJSON(@Path("top") String top);


}
