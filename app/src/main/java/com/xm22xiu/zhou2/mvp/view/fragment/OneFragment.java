package com.xm22xiu.zhou2.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm22xiu.zhou2.R;
import com.xm22xiu.zhou2.adapter.RvAdapter;
import com.xm22xiu.zhou2.bean.House;
import com.xm22xiu.zhou2.mvp.presenter.HousePresenter;
import com.xm22xiu.zhou2.mvp.view.HouseView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class OneFragment extends Fragment implements HouseView {
    @BindView(R.id.one_rv)
    RecyclerView oneRv;
    Unbinder unbinder;
    private HousePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fg, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //请求网络
        presenter = new HousePresenter(this);
        initRv();
    }

    private void initRv() {
        oneRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        presenter.getHouse();
    }

    //内存优化
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    public void onGetHouseSuccess(House house) {
        List<House.DataBean> data = house.getData();
        RvAdapter adapter = new RvAdapter(data);
        oneRv.setAdapter(adapter);
    }
}
