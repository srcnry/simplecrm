package com.missingartifacts.crm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;
    private String OriginCountry;
    private String OriginCity;
    private String email;
    private String web;

    @OneToMany(mappedBy = "customer")
    private Set<Vessel> vessels = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private List<Contact> contactList = new ArrayList<>();

    public Customer(){}

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOriginCountry() {
        return OriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        OriginCountry = originCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getOriginCity() {
        return OriginCity;
    }

    public void setOriginCity(String originCity) {
        OriginCity = originCity;
    }

    public Set<Vessel> getVessels() {
        return vessels;
    }

    public void setVessels(Set<Vessel> vessels) {
        this.vessels = vessels;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
