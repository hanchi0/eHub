package com.jaemion.eHub.network;


import com.jaemion.eHub.network.model.UserData;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkInterface {
    @POST("api/User")
    @FormUrlEncoded
    Call<UserData> createUser(@Field("id")String user_id, @Field("pw")String user_pw, @Field("type")int user_type);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://13.209.145.113:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
