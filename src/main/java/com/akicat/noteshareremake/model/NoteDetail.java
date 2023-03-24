package com.akicat.noteshareremake.model;

import java.util.Date;

public class NoteDetail {
    private String upload_user;
    private String pic_path;
    private String note_name;
    private Date upload_date;
    private String upload_code;
    private int note_id;
    private int user_id;
    private String user_email;

    @Override
    public String toString() {
        return "NoteDetail{" +
                "upload_user='" + upload_user + '\'' +
                ", pic_path='" + pic_path + '\'' +
                ", note_name='" + note_name + '\'' +
                ", upload_date=" + upload_date +
                ", upload_code='" + upload_code + '\'' +
                ", note_id=" + note_id +
                ", user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                '}';
    }

    public String getUpload_user() {
        return upload_user;
    }

    public void setUpload_user(String upload_user) {
        this.upload_user = upload_user;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }

    public String getUpload_code() {
        return upload_code;
    }

    public void setUpload_code(String upload_code) {
        this.upload_code = upload_code;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
