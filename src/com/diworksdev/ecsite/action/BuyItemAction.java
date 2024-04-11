package com.diworksdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
    public Map<String, Object> session;
    private int count;
    private String pay;

    @Override
    public String execute() {
        // セッションに購入商品の数量と支払い方法を保存する
        session.put("count", count);

        // 合計金額を計算してセッションに保存する
        int intCount = count;
        int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
        session.put("total_price", intCount * intPrice);

        // 支払い方法に応じてセッションに保存する
        String payment;
        if (pay.equals("1")) {
            payment = "現金払い";
        } else {
            payment = "クレジットカード";
        }
        session.put("payment_method", payment);

        return SUCCESS;
    }

    // 購入商品の数量を設定するメソッド
    public void setCount(int count) {
        this.count = count;
    }

    // 支払い方法を設定するメソッド
    public void setPay(String pay) {
        this.pay = pay;
    }

    // セッションを設定するメソッド
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
