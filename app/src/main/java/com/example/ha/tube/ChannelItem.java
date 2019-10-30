package com.example.ha.tube;

/**
 * Created by ha on 2019-10-30.
 */

public class ChannelItem {
    String cname;
    String cart;
    String cid;
    String subscribers;

    public ChannelItem(String s1, String s2, String s3, String s4) {
        this.cname = s1;
        this.cart = s2;
        this.cid = s3;
        this.subscribers = s4;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSubscribers() {
        return "구독자 수 "+subscribers+"명";
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }
}
