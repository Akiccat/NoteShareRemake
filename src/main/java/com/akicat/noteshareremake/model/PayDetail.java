package com.akicat.noteshareremake.model;

import java.util.Date;

public class PayDetail {
    private int dst_userid;
    private int src_userid;
    private String pay_code;
    private String word;
    private String note_code;
    private int note_id;
    private int price;
    private Date pay_date;
    private String src_username;
    private String dst_username;
    private int state;

    @Override
    public String toString() {
        return "PayDetail{" +
                "dst_userid=" + dst_userid +
                ", src_userid=" + src_userid +
                ", pay_code='" + pay_code + '\'' +
                ", word='" + word + '\'' +
                ", note_code='" + note_code + '\'' +
                ", note_id=" + note_id +
                ", price=" + price +
                ", pay_date=" + pay_date +
                ", src_username='" + src_username + '\'' +
                ", dst_username='" + dst_username + '\'' +
                ", state=" + state +
                '}';
    }

    public int getDst_userid() {
        return dst_userid;
    }

    public void setDst_userid(int dst_userid) {
        this.dst_userid = dst_userid;
    }

    public int getSrc_userid() {
        return src_userid;
    }

    public void setSrc_userid(int src_userid) {
        this.src_userid = src_userid;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNote_code() {
        return note_code;
    }

    public void setNote_code(String note_code) {
        this.note_code = note_code;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getSrc_username() {
        return src_username;
    }

    public void setSrc_username(String src_username) {
        this.src_username = src_username;
    }

    public String getDst_username() {
        return dst_username;
    }

    public void setDst_username(String dst_username) {
        this.dst_username = dst_username;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
