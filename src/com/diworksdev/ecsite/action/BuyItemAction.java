package com.diworksdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class BuyItemAction extends ActionSupport implements SessionAware {
    public Map<String, Object> session;
    private int count;
    private String pay;

    public String execute() {
    	String result = SUCCESS; session.put("count", count);
        int intCount = Integer.parseInt(session.get("count").toString());
        int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
        session.put("total_price", intCount * intPrice);

        // 支払い方法に応じてセッションに保存する
        String payment;
        if (pay.equals("1")) {
            payment = "現金払い"; session.put("pay",payment);
        } else {
            payment = "クレジットカード"; session.put("pay",payment);
        }

        return result;
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
