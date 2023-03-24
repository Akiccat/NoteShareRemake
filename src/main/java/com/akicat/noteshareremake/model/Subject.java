package com.akicat.noteshareremake.model;

public class Subject {
    private int subject_id;
    private String name;
    private String pic_path;

    public Subject(int subject_id, String name, String pic_path) {
        this.subject_id = subject_id;
        this.name = name;
        this.pic_path = pic_path;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", name='" + name + '\'' +
                ", pic_path='" + pic_path + '\'' +
                '}';
    }
}
