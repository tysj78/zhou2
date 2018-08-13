package com.xm22xiu.zhou2.mvp.presenter;

import com.xm22xiu.zhou2.bean.House;
import com.xm22xiu.zhou2.mvp.model.HouseModel;
import com.xm22xiu.zhou2.mvp.view.HouseView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class HousePresenter {
    public HouseView view;
    private final HouseModel model;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HousePresenter(HouseView view) {
        this.view = view;
        model = new HouseModel();
    }

    public void getHouse() {
        model.getHouse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<House>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(House house) {
                        view.onGetHouseSuccess(house);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //内存优化
    public void onDestroy() {
        view = null;
        compositeDisposable.clear();
    }
}
