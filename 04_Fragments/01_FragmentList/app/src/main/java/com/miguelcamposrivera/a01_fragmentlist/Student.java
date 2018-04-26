package com.miguelcamposrivera.a01_fragmentlist;

class Student {
    private String name;
    private int age;
    private String schoolName;
    private String photoUrl;

    public Student(String name, int age, String schoolName, String photoUrl) {
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
        this.photoUrl = photoUrl;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
