package com.xm22xiu.zhou2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class VpAdapter extends FragmentPagerAdapter {
    private List<String> list;
    private List<Fragment> fgList;

    public VpAdapter(FragmentManager fm, List<String> list, List<Fragment> fgList) {
        super(fm);
        this.list = list;
        this.fgList = fgList;
    }

    @Override
    public Fragment getItem(int position) {
        return fgList.get(position);
    }

    @Override
    public int getCount() {
        return fgList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
