package com.kowsar.dynamiclocalization.model.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.kowsar.dynamiclocalization.networkcall.GDriveAPI;
import com.kowsar.dynamiclocalization.networkcall.LocaleRetrofitService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocaleRepository {
    private final String TAG = this.getClass().getSimpleName();
    private static LocaleRepository localeRepo;
    private MutableLiveData<String> responseLocaleLiveData;

    private Map<String, HashMap<String, String>> localesMap;

    public static LocaleRepository getInstance() {
        if (localeRepo == null) {
            return new LocaleRepository();
        }
        return localeRepo;
    }

    private GDriveAPI localeApi;

    private LocaleRepository() {
        Log.d(TAG, "LocaleRepository(): New instance created");
        localeApi = LocaleRetrofitService.getApiService();
        responseLocaleLiveData = new MutableLiveData<>();
        localesMap = new HashMap<>();
    }

    public void fetchLocaleFile() {
        Log.d(TAG, "fetchLocaleFile(): Enter");

        localeApi.downloadFileFromGdrive().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        String strJson = response.body().string();
                        Log.d(TAG, "onResponse():downloadFileFromGdrive-> Response String=" + strJson);
                        responseLocaleLiveData.postValue(strJson);
                        createLocaleHM(strJson);
                    } else {
                        Log.d(TAG, "onResponse():downloadFileFromGdrive-> Response success. data=" + response.message());
                        responseLocaleLiveData.postValue(null);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure(): downloadFileFromGdrive-> Response failed.");
            }
        });

    }

    private void createLocaleHM(String responseLocale) {
        Log.d(TAG, "createLocaleHM");
        try {
            JSONObject jsonObject = new JSONObject(responseLocale);
            JSONArray locale = jsonObject.getJSONArray("locale");
            for (int i = 0; i < locale.length(); i++) {
                HashMap<String,String> resIdsMap=null;
                JSONObject obj = locale.getJSONObject(i);
                String id = obj.getString("country_code");
                Log.d(TAG, "country code=" + id);
                JSONObject resIds = obj.getJSONObject("res_ids");
                Iterator<String> keys = resIds.keys();
                resIdsMap = new HashMap<>();
                while (keys.hasNext()) {
                    String key = keys.next();
                    if (!(resIds.get(key) instanceof JSONObject)) {
                        String val= (String) resIds.get(key);
                        Log.d(TAG, "key=" + key + " value=" + val);
                        resIdsMap.put(key, val);
                    }
                }
                localesMap.put(id,resIdsMap);
            }
            Log.d(TAG, "createLocaleHM() : JSOn parsing done");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Map<String, HashMap<String, String>> getLocalesMap() {
        return localesMap;
    }


    public MutableLiveData<String> getResponseLocaleLiveData() {
        Log.d(TAG, "getResponseLocaleLiveData(): Enter");
        return responseLocaleLiveData;
    }
}
