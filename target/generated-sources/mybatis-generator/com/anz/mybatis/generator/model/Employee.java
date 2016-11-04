package com.anz.mybatis.generator.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private Long id;

    private String firstName;

    private String lastName;

    private String idapUserName;

    private String gender;

    private Date birthDate;

    private String title;

    private String grade;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdapUserName() {
        return idapUserName;
    }

    public void setIdapUserName(String idapUserName) {
        this.idapUserName = idapUserName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}