package com.example.rajesh.moviesapp.Network;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestClient {

    private static ApiCall REST_CLIENT;


    static {
        setupRestClient();
    }

    private RestClient() {
    }

    public static ApiCall get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {


        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder client=new OkHttpClient.Builder();

        client.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                // http://samples.openweathermap.org/data/2.5/forecast?zip=94040&appid=b1b15e88fa797225412429c1c50c122a1
       // https://api.themoviedb.org/3/movie/now_playing?api_key=dc0682a32ff56442b42d09cf9bf59c91
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        REST_CLIENT = retrofit.create(ApiCall.class);

    }

}
