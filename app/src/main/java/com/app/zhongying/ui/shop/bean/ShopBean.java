package com.app.zhongying.ui.shop.bean;

public class ShopBean {

    private String url;
    private String name;
    private int price;
    private boolean status;//当前的状态

    private int num=1;


    public ShopBean(String url, String name, int price) {
        this.url = url;
        this.name = name;
        this.price = price;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
