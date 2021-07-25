package com.example.test_one_suitmedia.API;

import com.example.test_one_suitmedia.Model.GuestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestUser {

    @GET("596dec7f0f000023032b8017/")
    Call<List<GuestModel>> ardGetGuest();
}
