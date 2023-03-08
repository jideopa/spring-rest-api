package com.springbootrest.model;


import jakarta.persistence.*;

@Entity
@Table
public class EmployeRecord {
    @Id //ID is auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "employeeName")
    String employeeName;

    @Column
    String employeeCountry;

    public EmployeRecord(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public String getEmployeeCountry() {
        return employeeCountry;
    }

    public void setEmployeeCountry(String employeeCountry) {
        this.employeeCountry = employeeCountry;
    }

    @Override
    public String toString() {
        return "EmployeRecord{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeCountry='" + employeeCountry + '\'' +
                '}';
    }
}
