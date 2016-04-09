package com.android.HuoBiAssistant.model.bean;

import com.android.HuoBiAssistant.model.ParamName;

/**
 * Created by Dragon丶Lz on 2016/4/5.
 */
public class NowEntrust {
    @ParamName("id")
    private String id;

    @ParamName("type")
    private String type;

    @ParamName("order_price")
    private String order_price;

    @ParamName("order_amount")
    private String order_amount;

    @ParamName("processed_amount")
    private String processed_amount;

    @ParamName("order_time")
    private String order_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getProcessed_amount() {
        return processed_amount;
    }

    public void setProcessed_amount(String processed_amount) {
        this.processed_amount = processed_amount;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
}
