package com.kowsar.dynamiclocalization.networkcall;

import com.kowsar.dynamiclocalization.model.response.ResponseLocale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface GDriveAPI {
    @Streaming
    @GET("uc?id=1V0-IMhFJxa97Nrxww-KhwFnYav82KxbS&export=download")
    Call<ResponseLocale> downloadFileFromGdrive(/*@Url String fileUrl*/);
}
