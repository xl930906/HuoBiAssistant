package com.android.HuoBiAssistant.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.android.HuoBiAssistant.config.Constants;
import com.android.HuoBiAssistant.model.IAccountInfo;
import com.android.HuoBiAssistant.model.IBuy;
import com.android.HuoBiAssistant.model.bean.AccountInfo;
import com.android.HuoBiAssistant.model.bean.AccountInfoBean;
import com.android.HuoBiAssistant.model.imp.AccountInfoModel;
import com.android.HuoBiAssistant.ui.view.IAccountActivityView;
import com.android.HuoBiAssistant.util.MD5Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Dragon丶Lz on 2016/4/3.
 */
public class AccountActivityPresenter {
    private IAccountActivityView iAccountActivityView;
    private IAccountInfo iAccountInfo;
    private Context context;
    private List<AccountInfoBean> dataList = new ArrayList<>();
    public AccountActivityPresenter(IAccountActivityView view,Context context){
        this.context = context;
        iAccountActivityView = view;
        iAccountInfo = new AccountInfoModel(context);

    }


    public void loadData(){
        String url_post_body = "access_key=" + Constants.HUOBI_ACCESS_KEY + "&created=" + getTimestamp() + "&method=" + Constants.ACCOUNT_INFO + "&secret_key=" + Constants.HUOBI_SECRET_KEY;
        final String signLater = MD5Utils.MD5(url_post_body).toLowerCase();
        Log.d("TAG-->",Constants.ACCOUNT_INFO+"++"+getTimestamp()+"++"+signLater);
        iAccountInfo.loadAccountinfoData(Constants.ACCOUNT_INFO, getTimestamp(), Constants.HUOBI_ACCESS_KEY, signLater,new Callback<AccountInfo>() {
            @Override
            public void success(AccountInfo accountInfo, Response response) {
                List<String> titleLsit = iAccountInfo.loadTitleData();
                dataList.add(new AccountInfoBean(titleLsit.get(0), accountInfo.getTotal() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(1), accountInfo.getNet_asset() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(2), accountInfo.getAvailable_cny_display() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(3), accountInfo.getAvailable_btc_display() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(4), accountInfo.getFrozen_cny_display() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(5), accountInfo.getFrozen_btc_display() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(6), accountInfo.getLoan_cny_display() + ""));
                dataList.add(new AccountInfoBean(titleLsit.get(7), accountInfo.getLoan_btc_display() + ""));
                iAccountActivityView.showData(dataList);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG-->",error.toString());

                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public static long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }



}
