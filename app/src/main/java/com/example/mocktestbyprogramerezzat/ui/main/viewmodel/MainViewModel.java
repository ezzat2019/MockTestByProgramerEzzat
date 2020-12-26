package com.example.mocktestbyprogramerezzat.ui.main.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mocktestbyprogramerezzat.data.model.RandomTestModel;
import com.example.mocktestbyprogramerezzat.data.repo.RandomTestRepo;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
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
                .subscribe(api -> api.subscribe(new Observer<RandomTestModel>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull RandomTestModel randomTestModel) {
                                if (randomTestModel!=null)
                                {
                                    modelMutableLiveData.postValue(randomTestModel);
                                }


                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        }
                ));
    }
}
