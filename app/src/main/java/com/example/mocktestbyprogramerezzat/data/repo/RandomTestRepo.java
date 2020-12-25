package com.example.mocktestbyprogramerezzat.data.repo;

import com.example.mocktestbyprogramerezzat.data.api.RandomTestApi;
import com.example.mocktestbyprogramerezzat.data.model.RandomTestModel;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class RandomTestRepo {
    RandomTestApi randomTestApi;

    @Inject
    public RandomTestRepo(RandomTestApi randomTestApi) {
        this.randomTestApi = randomTestApi;
    }


    public Observable<RandomTestModel> getRandomApi() {
        return randomTestApi.getRandomeTest();
    }
}
