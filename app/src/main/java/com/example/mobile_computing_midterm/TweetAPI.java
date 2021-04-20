package com.example.mobile_computing_midterm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TweetAPI {

    @GET("/")
    Call<List<Tweet>> loadChanges(@Query("q") String status);
}