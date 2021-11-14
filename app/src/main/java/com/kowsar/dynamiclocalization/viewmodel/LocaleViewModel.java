package com.kowsar.dynamiclocalization.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kowsar.dynamiclocalization.model.data.LocaleRepository;

import java.util.Map;

public class LocaleViewModel extends ViewModel {
    private final String TAG= this.getClass().getSimpleName();
    private LocaleRepository localeRepository;
    MutableLiveData<String> responseLiveddata;

    public void init(){
        Log.d(TAG, "init(): Enter");
        localeRepository= LocaleRepository.getInstance();
        responseLiveddata = localeRepository.getResponseLocaleLiveData();

    }

    public void getGDriveLocaleFile(){
        Log.d(TAG, "getGDriveLocaleFile(): Fetching Locale file from GDrive");
        localeRepository.fetchLocaleFile();
    }

    public MutableLiveData<String> getResponseLiveddata() {
        return responseLiveddata;
    }

    public String getLocaleString(String locale, String resId) {
        Log.d(TAG, "getLocaleString():locale="+locale+", resId="+resId);
        Map localeMap=localeRepository.getLocalesMap();
        if (localeMap != null && localeMap.containsKey(locale)){
            Map resMap= (Map) localeMap.get(locale);
            if (resMap != null && resMap.containsKey(resId)){
                return (String) resMap.get(resId);
            }
        }
        return null;
    }
}
