package com.glemontree.mybatis.bean;

import com.glemontree.mybatis.base.BasePage;

import java.util.List;

public class Clazz /*extends BasePage*/ {
    /**
     * id
     */
    private Integer id;

    /**
     * 班级名
     */
    private String name;

    /**
     * 班级学生
     */
    private List<Student> students;

    /**
     * 班主任
     */
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", teacher=" + teacher +
                '}';
    }

    public Clazz(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clazz() {

    }
}
