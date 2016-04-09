package com.android.HuoBiAssistant.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.HuoBiAssistant.config.Constants;
import com.android.HuoBiAssistant.model.IBuy;
import com.android.HuoBiAssistant.model.bean.AccountInfo;
import com.android.HuoBiAssistant.model.bean.AccountInfoBean;
import com.android.HuoBiAssistant.model.bean.Buy;
import com.android.HuoBiAssistant.model.imp.BuyModel;
import com.android.HuoBiAssistant.util.MD5Utils;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by xianling on 2016/4/9.
 */
public class   BuyPresenter {
    private IBuy iBuy;
    private Context context;
    public BuyPresenter(Context context){
        this.context=context;
        iBuy=new BuyModel(context);
    }
    public void loadData(){
        String url_post_body = "access_key=" + Constants.HUOBI_ACCESS_KEY +"&amount=10"+ "&created=" + getTimestamp() + "&method=" + Constants.BUY +"&price=5000"+ "&secret_key=" + Constants.HUOBI_SECRET_KEY;
        final String signLater = MD5Utils.MD5(url_post_body).toLowerCase();
        Log.d("TAG-->", Constants.BUY + "++" + getTimestamp() + "++" + signLater);
        iBuy.buyDataFromHttp(Constants.BUY, getTimestamp(), Constants.HUOBI_ACCESS_KEY, signLater, "1", "5000", "10", new Callback<Buy>() {
            @Override
            public void success(Buy buy, Response response) {
                System.out.println(response.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.toString());
            }
        });
    }

    public long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }
}
