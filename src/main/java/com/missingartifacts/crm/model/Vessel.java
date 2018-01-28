package com.missingartifacts.crm.model;

import javax.persistence.*;

@Entity
public class Vessel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vesselName;
    private String typeOfVessel;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Vessel(){}

    public Vessel(String vesselName, String typeOfVessel) {
        this.vesselName = vesselName;
        this.typeOfVessel = typeOfVessel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getTypeOfVessel() {
        return typeOfVessel;
    }

    public void setTypeOfVessel(String typeOfVessel) {
        this.typeOfVessel = typeOfVessel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
