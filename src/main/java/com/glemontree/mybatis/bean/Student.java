package com.glemontree.mybatis.bean;

import java.util.List;

public class Student extends User {

    // 性别
    private String sex;

    // 学号
    private String studentId;

    /**
     * 所属班级
     */
    private Clazz clazz;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", studentId='" + studentId + '\'' +
                ", clazz=" + clazz +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Student(Integer id, String name, String password, String sex, String studentId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.studentId = studentId;
    }

    public Student(Integer id, String name, String password, String sex, String studentId, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.studentId = studentId;
        this.clazz = clazz;
    }

    public Student(String name,String password) {
        this.name = name;
        this.password = password;
    }

    public Student() {

    }
}
