package com.xm22xiu.zhou2.mvp.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xm22xiu.zhou2.R;
import com.xm22xiu.zhou2.adapter.VpAdapter;
import com.xm22xiu.zhou2.mvp.view.fragment.OneFragment;
import com.xm22xiu.zhou2.mvp.view.fragment.ThreeFragment;
import com.xm22xiu.zhou2.mvp.view.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.main2_vp)
    ViewPager main2Vp;
    @BindView(R.id.main2_tabl)
    TabLayout main2Tabl;
    private List<String> titleList;
    private List<Fragment> fgList = new ArrayList<>();
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        unbinder = ButterKnife.bind(this);
        initData();
        initTab();
    }

    private void initTab() {
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), titleList, fgList);
        main2Vp.setAdapter(adapter);
        //关联
        main2Tabl.setupWithViewPager(main2Vp);
    }

    private void initData() {
        titleList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            titleList.add("页面" + i);
        }

        fgList.add(new OneFragment());
        fgList.add(new TwoFragment());
        fgList.add(new ThreeFragment());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
