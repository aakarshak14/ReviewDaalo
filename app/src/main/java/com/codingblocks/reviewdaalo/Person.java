package com.codingblocks.reviewdaalo;

import java.io.Serializable;

/**
 * Created by Aakarshak on 23-01-2017.
 */

public class Person implements Serializable{
    String name;
    int age;
    String country;
    String emailid;
    String username;
    String password;

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getCountry() {
        return country;
    }

    public Person(int age, String name, String country, String emailid,  String username ,String password) {
        this.age = age;
        this.country = country;
        this.emailid = emailid;
        this.name = name;
        this.password = password;
        this.username = username;


    }

}
