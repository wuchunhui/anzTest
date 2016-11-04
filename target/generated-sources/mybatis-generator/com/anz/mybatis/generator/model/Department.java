package com.anz.mybatis.generator.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Long id;

    private String name;

    private String location;

    private Long manager;

    private Integer openPositions;

    private Long parentDepartment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public Integer getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(Integer openPositions) {
        this.openPositions = openPositions;
    }

    public Long getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Long parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
}