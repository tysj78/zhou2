package com.xm22xiu.zhou2.util;

import com.xm22xiu.zhou2.bean.House;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public interface MyRetrofit {
    @GET("api.php/api/Lists/content_lists&version=1.7&token=&type=1&cat=&catid2=&page=1")
    Observable<House> getHouse();
}
