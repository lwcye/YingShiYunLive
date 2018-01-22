package com.cmcc.yingshiyunlive.base;

import android.os.Bundle;

import com.cqmc.libdev.common.base.BasePresenter;
import com.cqmc.libdev.common.base.BaseView;

/**
 * 重庆城的基础活动(MVP)
 *
 * @author mos
 * @date 2017.04.24
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public abstract class MyBaseMVPActivity<I extends BaseView, T extends BasePresenter<I>> extends MyBaseActivity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建Presenter
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((I) this);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (null == mPresenter) {
            // 创建Presenter
            mPresenter = createPresenter();
            if (mPresenter != null) {
                mPresenter.attachView((I) this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
