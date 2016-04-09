package com.android.HuoBiAssistant.model;

import com.android.HuoBiAssistant.model.bean.Buy;
import com.android.HuoBiAssistant.model.bean.NowEntrust;

import retrofit.Callback;

/**
 * Created by xianling on 2016/4/9.
 */
public interface IBuy {
    void buyDataFromHttp(String method,long created,String access_key,String sign,String coin_type,String price,String amount, Callback<Buy> callback);

    void LoadbuyDataFromDB();


}
