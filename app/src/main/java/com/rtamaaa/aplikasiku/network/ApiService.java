package com.rtamaaa.aplikasiku.network;

import com.rtamaaa.aplikasiku.models.ResponseMessage;
import com.rtamaaa.aplikasiku.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ApiService {

    @POST("login.php")
    Call<ResponseMessage> login(@Body User user);

    @POST("register.php")
    Call<ResponseMessage> register(@Body User user);


}
