package com.example.appretrofitgetpost;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface CheckoApiService {
    @GET("company")
    Call<CompanyInfo> getCompanyInfo(
            @Query("key") String apiKey,
            @Query("inn") String inn
    );
}
