package com.piyush.MVCProject.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

//Makes Student class a JPA entity
@Entity
//We map this entity to data base table called students, if We don't JPA will do it for us
@Table(name = "students")
public class Student {
    //Primary key for the table
    @Id
    // Strategy for Generating primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Even if we dont provide @Column annotation, JPA will automatically name the column name same as field name
    @Column(name = "first_name", nullable = false)
    private String firstName;

    private String lastName;
    private String email;

    //Whenever you create a parameterized constructor like below, also create a default constructor
    //for hibernate
    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
