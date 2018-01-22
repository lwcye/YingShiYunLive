package com.cmcc.yingshiyunlive.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.cqmc.libdev.common.base.BaseActivity;


/**
 * 重庆城的基础活动
 *
 * @author mos
 * @date 2017.04.24
 * @note -
 * <p>
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class MyBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
