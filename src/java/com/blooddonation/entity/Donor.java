package com.blooddonation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DONOR")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String bloodGroup;

    private int age;

    @OneToMany(
            mappedBy = "donor",
            cascade = CascadeType.PERSIST
    )
    private List<BloodDonation> donations = new ArrayList<>();

    // Default Constructor
    public Donor() {
    }

    // Get ID
    public Long getId() {
        return id;
    }

    // Set ID
    public void setId(Long id) {
        this.id = id;
    }

    // Get Name
    public String getName() {
        return name;
    }

    // Set Name
    public void setName(String name) {
        this.name = name;
    }

    // Get Email
    public String getEmail() {
        return email;
    }

    // Set Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get Phone
    public String getPhone() {
        return phone;
    }

    // Set Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Get Blood Group
    public String getBloodGroup() {
        return bloodGroup;
    }

    // Set Blood Group
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    // Get Age
    public int getAge() {
        return age;
    }

    // Set Age
    public void setAge(int age) {
        this.age = age;
    }

    // Get Donations
    public List<BloodDonation> getDonations() {
        return donations;
    }

    // Set Donations
    public void setDonations(List<BloodDonation> donations) {
        this.donations = donations;
    }

    // Add Donation
    public void addDonation(BloodDonation donation) {
        donations.add(donation);
        donation.setDonor(this);
    }
}