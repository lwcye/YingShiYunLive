package com.cmcc.yingshiyunlive.network;

/**
 * 网络接口定义
 *
 * @author mos
 * @date 2017.03.17
 * @note 1. 用户服务是Session相关的，请在创建会话后进行初始化
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class HttpApi {
    /** URL */
    private static String sUrl = "";

    /**
     * 设置统计服务的URL
     *
     * @param url url
     */
    public static void setUrl(String url) {
        sUrl = url;
    }

    /**
     * 获取产品服务(固定密钥，但是会传递Session)
     *
     * @return 服务对象
     */
//    public static synchronized ProductService getProductService() {
//        if (sProductService == null) {
//            // DES加密拦截
//            List<Interceptor> ssInterceptorList = new ArrayList<>();
//            ssInterceptorList.add(new LoggerInterceptor());
//            ssInterceptorList.add(new DESInterceptor(new DESInterceptor.IDESListener() {
//                @Override
//                public String onGetDesKey() {
//
//                    return DynamicValues.getDesKey();
//                }
//            }));
//            ssInterceptorList.add(createSessionInterceptor());
//
//            sProductService = RetrofitWrapper.createInstance(sUrl, GsonConverter.createCmsInfoConverter(),
//                    ssInterceptorList, false).create(ProductService.class);
//        }
//
//        return sProductService;
//    }
}
