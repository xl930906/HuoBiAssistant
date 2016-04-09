package com.android.HuoBiAssistant.model.bean;

import com.android.HuoBiAssistant.model.ParamName;

/**
 * Created by xianling on 2016/4/9.
 */
public class Buy {
    @ParamName("result")
    private String result;

    @ParamName("id")
    private String id;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
