package com.cmcc.yingshiyunlive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqmc.libdev.common.base.BaseFragment;

/**
 * 重庆城的fragment基类
 *
 * @author mos
 * @date 2017.04.25
 * @note 1. 项目中所有子类必须继承自此基类
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public abstract class MyBaseFragment extends BaseFragment {
    /** 根布局 */
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(getContentView(), container, false);
        initView(mView);
        return mView;
    }

    /**
     * 获得根布局
     *
     * @return View 根布局
     */
    @Override
    public View getView() {
        return mView;
    }

    /**
     * 设置ContentView的ResId
     *
     * @return ContentView的ResId
     */
    public abstract int getContentView();

    /**
     * 初始化布局
     *
     * @param rootView 根布局
     */
    public abstract void initView(View rootView);
}
