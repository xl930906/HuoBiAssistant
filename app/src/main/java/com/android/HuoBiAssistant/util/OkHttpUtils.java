package com.android.HuoBiAssistant.util;

import android.content.Context;


import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;





/**
 * Created by Dragon丶Lz on 2016/4/2.
 */
public class OkHttpUtils {

    private static OkHttpClient singleton;

    public static OkHttpClient getInstance(Context context) {
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {
                    File cacheDir = new File(context.getCacheDir().toString());

                    singleton = new OkHttpClient();
                    singleton.setCache(new Cache(cacheDir, Runtime.getRuntime().maxMemory() / 1024 / 8));
                    singleton.setConnectTimeout(30000, TimeUnit.MILLISECONDS);
                    singleton.setReadTimeout(30000, TimeUnit.MILLISECONDS);
                }
            }
        }
        return singleton;
    }


    public static Response execute(Request request) throws IOException {
        return singleton.newCall(request).execute();
    }

    public static void enqueue(Request request, Callback responseCallback){
        singleton.newCall(request).enqueue(responseCallback);
    }

    public static void enqueue(Request request){
        singleton.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {

            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {

            }
        });
    }

    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
/**
       private static final String CHARSET_NAME = "UTF-8";

    public static String formatParams(List<BasicNameValuePair> params){
        return URLEncodedUtils.format(params, CHARSET_NAME);
    }

    public static String attachHttpGetParams(String url, List<BasicNameValuePair> params){
        return url + "?" + formatParams(params);
    }

    public static String attachHttpGetParam(String url, String name, String value){
        return url + "?" + name + "=" + value;
    }

 **/
}
