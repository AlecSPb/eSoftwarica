package com.manishbsta.esoftwarica.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String fullname;
    private String age;
    private String gender;
    private String address;

    public Student(String fullname, String age, String gender, String address) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}
