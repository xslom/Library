package com.example.recycler.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIINTERFACE {
    @GET("master/Libarary.json")
    Call<List<Books>> getBooks();

}
