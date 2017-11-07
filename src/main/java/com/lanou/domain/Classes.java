package com.lanou.domain;

/**
 * Created by dllo on 17/11/2.
 */
public class Classes {
    private int id; //主键id
    private String className; //班级名称
    private String note; //备注

    public Classes() {
    }

    public Classes(String className, String note) {
        this.className = className;
        this.note = note;
    }

    public Classes(int id, String className, String note) {
        this.id = id;
        this.className = className;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
