package com.example.mobile_computing_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = findViewById(R.id.textView);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TweetAPI service = retrofit.create(TweetAPI.class);


        Call<List<Tweet>> call = service.getTweets();
//        Call<UsersResponse>
        call.enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {

                    textView.setText(response.body().get(0).getUserId());


            }

            @Override
            public void onFailure(Call<List<Tweet>> call, Throwable t) {
//                Log.e("","ahabb is awesome");

                Log.e("", t.getLocalizedMessage());
            }
        });
    }
}