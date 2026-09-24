package com.example.quizzaplikacja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {
    @GET
    public Call<List<Pytanie>> getPytania(); //metoda abstrakcyjna
}
