package com.xm22xiu.zhou2.mvp.model;

import com.xm22xiu.zhou2.bean.House;
import com.xm22xiu.zhou2.util.MyRetrofit;
import com.xm22xiu.zhou2.util.RetrofitUtil;

import io.reactivex.Observable;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class HouseModel {
    public Observable<House> getHouse() {
        return RetrofitUtil.getRetrofitUtil().create(MyRetrofit.class).getHouse();
    }
}
