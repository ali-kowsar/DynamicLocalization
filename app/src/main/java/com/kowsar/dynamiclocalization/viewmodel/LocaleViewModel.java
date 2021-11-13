package com.kowsar.dynamiclocalization.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kowsar.dynamiclocalization.model.data.LocaleRepository;
import com.kowsar.dynamiclocalization.model.response.ResponseLocale;

public class LocaleViewModel extends ViewModel {
    private final String TAG= this.getClass().getSimpleName();
    private LocaleRepository localeRepository;
    MutableLiveData<ResponseLocale> responseLiveddata;

    public void init(){
        Log.d(TAG, "init(): Enter");
        localeRepository= LocaleRepository.getInstance();
        responseLiveddata = localeRepository.getResponseLocaleLiveData();

    }

    public void getGDriveLocaleFile(String date){
        localeRepository.fetchLocaleFile();
    }

    public MutableLiveData<ResponseLocale> getResponseLiveddata() {
        return responseLiveddata;
    }
}
