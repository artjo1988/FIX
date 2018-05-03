package ru.ivmiit.models;

import java.time.LocalDate;

/**
 * Created by Макс on 24.03.2018.
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private LocalDate birthDay;
    private String city;

    public User(Integer id, String name, String password, LocalDate birthDay, String city) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthDay = birthDay;
        this.city = city;
    }

    public User(String name, String password, LocalDate birthDay, String city) {
        this.name = name;
        this.password = password;
        this.birthDay = birthDay;
        this.city = city;
    }

    public User(String name, LocalDate birthDay, String city) {
        this.name = name;
        this.birthDay = birthDay;
        this.city = city;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", city='" + city + '\'' +
                '}';
    }
}
