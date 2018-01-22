package com.cmcc.yingshiyunlive.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.cmcc.yingshiyunlive.R;
import com.cqmc.libdev.common.base.BaseActivity;
import com.cqmc.libdev.common.base.BaseApplication;
import com.cqmc.libdev.common.network.retrofit.RetrofitWrapper;
import com.cqmc.libdev.common.utils.SimpleTitleBarBuilder;
import com.cqmc.libdev.common.utils.loader.LoaderFactory;
import com.cqmc.libdev.common.utils.loader.Options;
import com.cqmc.opsrc.blankj.utilcode.util.ConvertUtils;
import com.cqmc.opsrc.blankj.utilcode.util.LogUtils;
import com.cqmc.opsrc.blankj.utilcode.util.ResUtils;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.connection.FileDownloadUrlConnection;
import com.liulishuo.filedownloader.services.DownloadMgrInitialParams;

import java.net.Proxy;

/**
 * <p>describe</p><br>
 *
 * @author - lwc
 * @date - 2018/1/22
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.init(true, false, 'v', "cqcity");
        // 网络初始化
        RetrofitWrapper.init(this);
        // 文件下载器
        FileDownloader.init(this, new DownloadMgrInitialParams.InitCustomMaker()
                .connectionCreator(new FileDownloadUrlConnection
                        .Creator(new FileDownloadUrlConnection.Configuration()
                        .connectTimeout(10_000)
                        .readTimeout(10_000)
                        .proxy(Proxy.NO_PROXY)
                )));
        // 初始化标题栏
        initSimpleTitleBarOptions();
        // 图片加载初始化
        initImageLoader();

        // 检查用户登录情况，未登录跳转登陆界面
        setCheckLoginInterceptor(new BaseActivity.ICheckLoginInterceptor() {
            @Override
            public boolean checkLoginBeforeAction(String actionAfterLogin, Bundle data) {
                // TODO: lwc 2018/1/22 是否登录
                return true;
            }
        });
    }

    private void initImageLoader() {
        LoaderFactory.getLoader().init(this, new Options(Options.RES_NONE, Options.RES_NONE, 0.1f));
    }

    /**
     * 初始化标题栏的参数
     */
    private void initSimpleTitleBarOptions() {
        SimpleTitleBarBuilder.DefaultOptions options = new SimpleTitleBarBuilder.DefaultOptions();

        // 背景
        options.backgroundColor = ResUtils.getColor(R.color.top_bar_background);
        options.titleBarHeight = getResources().getDimensionPixelSize(R.dimen.top_bar_height);

        // 左边
        options.leftTextColor = ResUtils.getColor(R.color.top_bar_text_color);
        options.leftTextSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.font_small));
        options.leftBackDrawable = R.drawable.ic_back_gray;

        // 右边
        options.rightTextColor = ResUtils.getColor(R.color.top_bar_text_color);
        options.rightTextSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.font_small));

        // 标题
        options.titleColor = ResUtils.getColor(R.color.top_bar_title_color);
        options.titleSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.font_huge));

        // 阴影
        options.shadowHeight = (int) ResUtils.getDimensionPixelSize(R.dimen.top_bar_shadow_height);
        options.shadowColor = ResUtils.getColor(R.color.top_bar_shadow_color);

        // 6.0一下系统不使用沉浸式状态栏
        options.immersive = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;

        SimpleTitleBarBuilder.initDefaultOptions(options);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
