package com.validation_form_sign_up.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "khong duoc de rong")
    @Size(min = 5, max = 45, message = "bat buoc lon hon 5 va be hon 45")
    private String firstName;
    @NotBlank(message = "khong duoc de rong")
    @Size(min = 5, max = 45, message = "bat buoc lon hon 5 va be hon 45")
    private String lastName;
    @NotBlank(message = "khong duoc de rong")
    @Pattern(regexp = "^0[0-9]+", message = "nhap khong dung dinh dang")
    @Size(min = 10, max = 11, message = "bat buoc lon hon 10 va be hon 11")
    private String phoneNumber;
    @Min(value = 18, message = "do tuoi it nhat la 18")
    private int age;
    @NotBlank(message = "khong duoc de rong")
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", message = "nhap khong dung dinh dang")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
