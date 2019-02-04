package com.jaemion.eHub.network;


import android.service.autofill.UserData;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkInterface {
    @POST("api/users/sign-in")
    @FormUrlEncoded
    Call<UserData> signIn(@Field("user_id")String user_id, @Field("password")String user_pw);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.34:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
