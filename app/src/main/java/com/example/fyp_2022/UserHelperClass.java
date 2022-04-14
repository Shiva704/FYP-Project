package com.example.fyp_2022;

public class UserHelperClass {

    String username, phonenumber, email, password, sex, age;

    public UserHelperClass() {

    }



    public UserHelperClass(String username, String phonenumber, String email, String password, String sex, String age) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
