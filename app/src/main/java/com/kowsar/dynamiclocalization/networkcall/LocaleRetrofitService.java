package com.kowsar.dynamiclocalization.networkcall;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocaleRetrofitService {

    //    public static String BASE_URL = "https://drive.google.com/"; //file/d/1TCD9cDV65BBZw0s-nOr17-Tcj2E5_-Df/view?usp=drivesdk";
    public static String BASE_URL = "https://drive.google.com/u/0/";//uc?id=1TCD9cDV65BBZw0s-nOr17-Tcj2E5_-Df&export=download
    private static Retrofit retrofit = null;

    public static GDriveAPI getApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient) // to print okhttp log on Logcat.
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GDriveAPI.class);
    }

}
