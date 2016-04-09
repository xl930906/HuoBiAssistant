package com.android.HuoBiAssistant.model.imp;

import android.content.Context;

import com.android.HuoBiAssistant.app.BaseModel;
import com.android.HuoBiAssistant.model.INowEntrust;
import com.android.HuoBiAssistant.model.bean.NowEntrust;

import retrofit.Callback;

/**
 * Created by Dragon丶Lz on 2016/4/5.
 */
public class NowEntrustModel extends BaseModel implements INowEntrust{


    public NowEntrustModel(Context context) {
        super(context);
    }

    @Override
    public void LoadNowEntrustDataFromHttp(String method,long created,String access_key,String sign,String coin_type, Callback<NowEntrust> callback) {
        getExperApi().get_now_entrust(method,created,access_key,sign,coin_type,callback);
    }

    @Override
    public void LoadNowEntrustDataFromDB() {

    }
}
