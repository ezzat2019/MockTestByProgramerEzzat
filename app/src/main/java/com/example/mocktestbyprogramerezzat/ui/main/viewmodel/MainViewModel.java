package com.example.mocktestbyprogramerezzat.ui.main.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mocktestbyprogramerezzat.data.model.RandomTestModel;
import com.example.mocktestbyprogramerezzat.data.repo.RandomTestRepo;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private final RandomTestRepo randomTestRepo;
    private final MutableLiveData<RandomTestModel> modelMutableLiveData = new MutableLiveData<>();

    @ViewModelInject
    public MainViewModel(RandomTestRepo randomTestRepo) {
        this.randomTestRepo = randomTestRepo;
    }

    public MutableLiveData<RandomTestModel> getModelMutableLiveData() {
        getRandomREsult();
        return modelMutableLiveData;
    }

    private void getRandomREsult() {
        Observable.interval(2, TimeUnit.SECONDS, Schedulers.io())
                .map(res -> randomTestRepo.getRandomApi())
                .observeOn(Schedulers.newThread())
                .subscribe(api -> api.subscribe(result -> modelMutableLiveData.postValue(result)));
    }
}
