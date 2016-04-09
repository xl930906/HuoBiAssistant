package com.android.HuoBiAssistant.model;



import com.android.HuoBiAssistant.model.bean.NowEntrust;

import retrofit.Callback;

/**
 * Created by Dragon丶Lz on 2016/4/5.
 */
public interface INowEntrust {

    void LoadNowEntrustDataFromHttp(String method,long created,String access_key,String sign,String coin_type, Callback<NowEntrust> callback);

    void LoadNowEntrustDataFromDB();
}
