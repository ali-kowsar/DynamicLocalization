package com.kowsar.dynamiclocalization.networkcall;

import com.kowsar.dynamiclocalization.model.response.ResponseLocale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface GDriveAPI {
    @Streaming
    @GET("uc?id=1TCD9cDV65BBZw0s-nOr17-Tcj2E5_-Df&export=download")
    Call<ResponseLocale> downloadFileFromGdrive(/*@Url String fileUrl*/);
}
