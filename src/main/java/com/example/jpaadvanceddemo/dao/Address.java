package com.example.jpaadvanceddemo.dao;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String postalCode;
}
