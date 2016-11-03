package com.tian.mvpdemo.http;

import com.tian.mvpdemo.bean.FuLiGirl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 网络请求
 */
public class RetrofitHelper {
    private static OkHttpClient okHttpClient = null;
    private static APIService fuliApis = null;

    public RetrofitHelper() {

        initRetrofit();
    }

    private void initRetrofit() {
        initOkhttp();
        fuliApis=getFuliApis();
    }

    private void initOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //缓存设置  暂不考虑
       /* if (BuildConfig.DEBUG) {
            // https://drakeet.me/retrofit-2-0-okhttp-3-0-config
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }*/
        // http://www.jianshu.com/p/93153b34310e
/*        File cacheFile = new File(Environment.getExternalStorageDirectory()+"cccc");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!new SystemUtil(context).isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };*/
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        };
//        builder.addInterceptor(apikey);
        //设置缓存
       /* builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);*/
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    public static APIService getFuliApis() {

        //addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        Retrofit fuliRetrofit = new Retrofit.Builder()
                .baseUrl(APIService.BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return fuliRetrofit.create(APIService.class);
    }
    public Observable<FuLiGirl> getFuliData() {
        return fuliApis.getFuliGirl();
    }
}
