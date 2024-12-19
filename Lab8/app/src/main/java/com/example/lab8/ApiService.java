package com.example.lab8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("users") // Получение списка пользователей
    Call<List<Element>> getElements();
}