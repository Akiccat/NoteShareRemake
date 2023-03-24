package com.akicat.noteshareremake.model;

import java.util.Date;

public class Note {
    private int note_id;
    private int is_free;
    private int subject_id;
    private String pic_path;
    private int user_id;
    private String note_name;
    private Date upload_date;
    private String upload_code;

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", is_free=" + is_free +
                ", subject_id=" + subject_id +
                ", pic_path='" + pic_path + '\'' +
                ", user_id=" + user_id +
                ", note_name='" + note_name + '\'' +
                ", upload_date=" + upload_date +
                ", upload_code='" + upload_code + '\'' +
                '}';
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getIs_free() {
        return is_free;
    }

    public void setIs_free(int is_free) {
        this.is_free = is_free;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
}

