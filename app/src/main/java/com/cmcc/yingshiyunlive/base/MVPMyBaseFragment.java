package com.cmcc.yingshiyunlive.base;

import android.os.Bundle;

import com.cqmc.libdev.common.base.BasePresenter;
import com.cqmc.libdev.common.base.BaseView;

/**
 * 重庆城的基于MVP的基础Fragment
 *
 * @author mos
 * @date 2017.04.25
 * @note 1. 泛型I代表视图的接口，例如Activity，Fragment提供给Presenter的接口
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public abstract class MVPMyBaseFragment<I extends BaseView, T extends BasePresenter<I>> extends MyBaseFragment {
    /** Presenter对象 */
    public T mPresenter;

    /**
     * 创建Presenter对象
     *
     * @return Presenter对象
     * @note 若需要使用MVP模式，则子类需实现此方法
     */
    protected abstract T createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建Presenter
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((I) this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
