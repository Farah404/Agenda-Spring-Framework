package com.axyus.agendaSpringWebApp.model;

import com.axyus.agendaSpringWebApp.utils.JdbcUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    //On utilise l'objet Integer plutôt que int pcq int n'est pas un objet et ne peut donc pas être égal à null
    private Integer addressId;
    @Column(name="street_number")
    private Integer streetNumber;
    @Column(name="street_name")
    private String streetName;
    @Column(name="city")
    private String city;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="country")
    private String country;

    public Address() {
    }

    public Address(Integer addressId, Integer streetNumber, String streetName, String city, String postalCode, String country) {
        this.addressId = addressId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(Integer streetNumber, String streetName, String city, String postalCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(ResultSet rs) throws SQLException {
        this.addressId = JdbcUtils.getIntIfColumnExists(rs, "address_id");
        this.streetNumber = JdbcUtils.getIntIfColumnExists(rs, "street_number");
        this.streetName = JdbcUtils.getStringColumnIfExists(rs, "street_name");
        this.city = JdbcUtils.getStringColumnIfExists(rs, "city");
        this.postalCode = JdbcUtils.getStringColumnIfExists(rs, "postal_code");
        this.country = JdbcUtils.getStringColumnIfExists(rs, "country");
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postalCode=" + postalCode + ", country=" + country + '}';
    }

}
