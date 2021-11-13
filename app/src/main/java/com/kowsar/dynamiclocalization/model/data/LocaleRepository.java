package com.kowsar.dynamiclocalization.model.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.kowsar.dynamiclocalization.model.response.ResponseLocale;
import com.kowsar.dynamiclocalization.networkcall.GDriveAPI;
import com.kowsar.dynamiclocalization.networkcall.LocaleRetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocaleRepository {
    private final String TAG= this.getClass().getSimpleName();
    private static LocaleRepository localeRepo;
    private MutableLiveData<ResponseLocale> responseLocaleLiveData;

    public static LocaleRepository getInstance(){
        if(localeRepo == null){
            return new LocaleRepository();
        }
        return localeRepo;
    }

    private GDriveAPI localeApi;

    private LocaleRepository(){
        Log.d(TAG,"LocaleRepository(): New instance created");
        localeApi = LocaleRetrofitService.getApiService();
        responseLocaleLiveData = new MutableLiveData<>();
    }

    public void fetchLocaleFile(){
        Log.d(TAG, "fetchLocaleFile(): Enter");

        localeApi.downloadFileFromGdrive().enqueue(new Callback<ResponseLocale>() {
            @Override
            public void onResponse(Call<ResponseLocale> call, Response<ResponseLocale> response) {
                Log.d(TAG, "onResponse(): downloadFileFromGdrive-> Response success. data=" + response.body());
                if (response.isSuccessful()) {
                    responseLocaleLiveData.postValue(response.body());
                }else {
                    Log.d(TAG, "onResponse():downloadFileFromGdrive-> Response success. data=" + response.message());
                    responseLocaleLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseLocale> call, Throwable t) {
                Log.d(TAG, "onFailure(): downloadFileFromGdrive-> Response failed.");
            }
        });

    }

    public MutableLiveData<ResponseLocale> getResponseLocaleLiveData() {
        Log.d(TAG,"getResponseLocaleLiveData(): Enter");
        return responseLocaleLiveData;
    }
}
