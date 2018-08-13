package com.xm22xiu.zhou2.util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class RetrofitUtil {

    private final Retrofit retrofit;
    private HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static final RetrofitUtil retrofitUtil = new RetrofitUtil();

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkClient())
                .build();
    }

    private OkHttpClient getOkClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static RetrofitUtil getRetrofitUtil() {
        return retrofitUtil;
    }

    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
