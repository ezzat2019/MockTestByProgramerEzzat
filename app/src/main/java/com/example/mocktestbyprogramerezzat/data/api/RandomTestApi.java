package com.example.mocktestbyprogramerezzat.data.api;

import com.example.mocktestbyprogramerezzat.data.model.RandomTestModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface RandomTestApi {
    @GET("random")
    Observable<RandomTestModel> getRandomeTest();
}
