package com.axyus.agendaSpringWebApp.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author farah.gauduin
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "lst_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="address_id")
    private Address address;

    public Customer() {
    }

    public Customer(Integer customerId, String lastName, String firstName, String username, String email, Integer phoneNumber, Address address) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(Integer customerId, String lastName, String firstName, String username, String email, Integer phoneNumber, Integer addressId) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String lastName, String firstName, String username, String email, Integer phoneNumber) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String lastName, String firstName, String username, String email, Integer phoneNumber, Integer addressId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(ResultSet rs) throws SQLException {
        this.customerId = rs.getInt("customer_id");
        this.lastName = rs.getString("lst_name");
        this.firstName = rs.getString("first_name");
        this.username = rs.getString("username");
        this.email = rs.getString("email");
        this.phoneNumber = rs.getInt("phone_number");
        this.address = new Address(rs);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
