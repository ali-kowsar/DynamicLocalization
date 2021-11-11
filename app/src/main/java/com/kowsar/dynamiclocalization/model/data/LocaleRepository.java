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
    }

    public void fetchLocaleFile(){

        localeApi.downloadFileFromGdrive().enqueue(new Callback<ResponseLocale>() {
            @Override
            public void onResponse(Call<ResponseLocale> call, Response<ResponseLocale> response) {
                Log.d(TAG, "onResponse(): getAPOD-> Response success. data=" + response.body());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse(): getAPOD-> Response success. data=" + response.body());
                    ResponseLocale responseLocale= response.body();
                    Log.d("Kowsar", "responseLocale ="+responseLocale);
                }else {
                    Log.d(TAG, "onResponse():getAPOD-> Response success. data=" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseLocale> call, Throwable t) {
                Log.d(TAG, "onFailure(): getAPOD-> Response failed.");
//                apodLiveData.postValue(null);
            }
        });

    }
}
