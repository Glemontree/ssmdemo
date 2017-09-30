package com.glemontree.mybatis.bean;

import java.util.List;

public class Student {

    // 主键
    private Integer id;

    // 姓名
    private String name;

    // 密码
    private String password;

    // 性别
    private String sex;

    // 学号
    private String studentId;

    /**
     * 所属班级
     */
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", studentId='" + studentId + '\'' +
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

    public Student() {

    }
}
