package com.android.HuoBiAssistant.model.rest;

import com.android.HuoBiAssistant.config.Constants;
import com.android.HuoBiAssistant.model.bean.AccountInfo;
import com.android.HuoBiAssistant.model.bean.Buy;
import com.android.HuoBiAssistant.model.bean.NowEntrust;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Dragon丶Lz on 2016/4/3.
 */
public interface ExperApi {


    @FormUrlEncoded
    @POST(Constants.api)
    void get_account_info(@Field("method") String method, @Field("created") long created,
               @Field("access_key")String access_key,@Field("sign") String sign,Callback<AccountInfo> cb);

    @FormUrlEncoded
    @POST(Constants.api)
    void get_now_entrust(@Field("method") String method, @Field("created") long created,
                          @Field("access_key")String access_key,@Field("sign") String sign,
                         @Field("coin_type") String coin_type, Callback<NowEntrust> cb);

    @FormUrlEncoded
    @POST(Constants.api)
    void buy(@Field("method") String method, @Field("created") long created,
                         @Field("access_key")String access_key,@Field("sign") String sign,
                         @Field("coin_type") String coin_type,@Field("price") String price,@Field("amount") String amount,
             Callback<Buy> cb);


}
