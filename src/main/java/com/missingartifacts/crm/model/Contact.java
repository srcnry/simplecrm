package com.missingartifacts.crm.model;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Salutation;
    private String contactName;
    private String contactSurname;

    private String title;
    private String email;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Contact(){}

    public Contact(String salutation, String contactName, String contactSurname, String title, String email, Customer customer) {
        Salutation = salutation;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.title = title;
        this.email = email;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
