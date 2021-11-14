package com.kowsar.dynamiclocalization.networkcall;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface GDriveAPI {
    @Streaming
//    @GET("uc?id=1V0-IMhFJxa97Nrxww-KhwFnYav82KxbS&export=download")
    @GET("uc?id=1W34z4OFjtzvJLwEPA4mTNhuRCOxovZkc&export=download")   // json string new

    Call<ResponseBody> downloadFileFromGdrive();
}
