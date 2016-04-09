package com.android.HuoBiAssistant.model.imp;

import android.content.Context;

import com.android.HuoBiAssistant.app.BaseModel;
import com.android.HuoBiAssistant.model.IBuy;
import com.android.HuoBiAssistant.model.bean.Buy;

import retrofit.Callback;

/**
 * Created by xianling on 2016/4/9.
 */
public class BuyModel extends BaseModel implements IBuy{
    public BuyModel(Context context) {
        super(context);
    }

    @Override
    public void buyDataFromHttp(String method, long created, String access_key, String sign, String coin_type, String price, String amount, Callback<Buy> callback) {
        getExperApi().buy(method,created,access_key,sign,coin_type,price,amount,callback);
    }

    @Override
    public void LoadbuyDataFromDB() {

    }
}
