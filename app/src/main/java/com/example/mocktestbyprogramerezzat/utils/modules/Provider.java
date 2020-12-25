package com.example.mocktestbyprogramerezzat.utils.modules;

import com.example.mocktestbyprogramerezzat.data.api.RandomTestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class Provider {
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl("http://51.195.89.92:6000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RandomTestApi provideTestApi(Retrofit retrofit) {
        return retrofit.create(RandomTestApi.class);
    }
}
