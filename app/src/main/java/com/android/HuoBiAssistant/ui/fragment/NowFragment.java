package com.android.HuoBiAssistant.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.HuoBiAssistant.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dragon丶Lz on 2016/4/1.
 */
public class NowFragment extends Fragment{
    @Bind(R.id.now_rv)
    RecyclerView now_rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View nowView = inflater.inflate(R.layout.fragment_buy, container, false);
        ButterKnife.bind(this,nowView);

        return nowView;
    }

}
