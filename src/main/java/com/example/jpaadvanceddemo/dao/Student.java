package com.example.jpaadvanceddemo.dao;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;

    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "current_street")),
            @AttributeOverride(name = "city", column = @Column(name = "current_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "current_postal"))
    })
    @Embedded
    Address currentAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "perm_street")),
            @AttributeOverride(name = "city", column = @Column(name = "perm_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "perm_postal"))
    })
    @Embedded
    private  Address permanentAddress;

    public Student(){

    }
}
