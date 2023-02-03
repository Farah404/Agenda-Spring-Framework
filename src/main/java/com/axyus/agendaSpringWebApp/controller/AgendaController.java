/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axyus.agendaSpringWebApp.controller;

import com.axyus.agendaSpringWebApp.model.Address;
import com.axyus.agendaSpringWebApp.model.Customer;
import com.axyus.agendaSpringWebApp.service.AgendaManager;
import org.springframework.ui.Model;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author farah.gauduin
 */
@Controller
public class AgendaController {

    @Autowired
    private AgendaManager agendaManager;

    @RequestMapping(value = "/home-page", method = RequestMethod.GET)
    public String index() {
        System.out.println("Showing home page");
        return "index";
    }

    @RequestMapping("/addresses")
    public String addresses(Model model) throws SQLException {
        model.addAttribute("addresses", agendaManager.getAllAddresses());
        System.out.println("Showing addresses list");
        return "addresses";
    }

    @RequestMapping("/create-address")
    public String createAddress() {
        System.out.println("Showing create address form");
        return "create-address";
    }

    @RequestMapping("/save-created-address")
    public String saveCreatedAddress(
            @ModelAttribute("address") Address address) throws SQLException {
        agendaManager.createAddress(address);
        return "redirect:/show-address/" + address.getAddressId();
    }

    @RequestMapping("show-address/{addressId}")
    public String showAddress(@PathVariable Integer addressId, Model model) throws SQLException {
        model.addAttribute("address", agendaManager.findAddressById(addressId));
        System.out.println("Showing address details");
        return "show-address";
    }

    @RequestMapping("/update-address/{addressId}")
    public String updateAddress(@PathVariable Integer addressId, Model model) throws SQLException {
        model.addAttribute("address", agendaManager.findAddressById(addressId));
        System.out.println("Showing update address form");
        return "update-address";
    }

    @RequestMapping("/save-updated-address")
    public String saveUpdatedAddress(
            @RequestParam Integer addressId,
            @RequestParam Integer streetNumber,
            @RequestParam String streetName,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String country) throws SQLException {
        Address address = agendaManager.findAddressById(addressId);
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);

        agendaManager.updateAddress(address);

        return "redirect:/show-address/" + address.getAddressId();

    }

    @RequestMapping("/delete-address")
    public String deleteAddress(@RequestParam Integer addressId) throws SQLException {
        Address address = agendaManager.findAddressById(addressId);
        agendaManager.deleteAddressById(address.getAddressId());
        return "redirect:/addresses";
    }

    @RequestMapping("/customers")
    public String customers(Model model) throws SQLException {
        model.addAttribute("customers", agendaManager.getAllCustomers());
        System.out.println("Showing customers list");
        return "customers";
    }

    @RequestMapping(value = "/create-customer", method = RequestMethod.GET)
    public String createCustomer() {
        System.out.println("Showing create customer form");
        return "create-customer";
    }

    @RequestMapping("/save-created-customer")
    public String saveCreatedCustomer(
            @RequestParam Integer streetNumber,
            @RequestParam String streetName,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String country,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam Integer phoneNumber) throws SQLException {
        Address address = new Address();
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);
        agendaManager.createAddress(address);
        System.out.println(address);

        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setFirstName(firstName);
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        agendaManager.createCustomer(customer);

        return "redirect:/show-customer/" + customer.getCustomerId();
    }

    @RequestMapping("/update-customer/{customerId}")
    public String updateCustomer(@PathVariable Integer customerId, Model model) throws SQLException {
        model.addAttribute("customer", agendaManager.findCustomerbyId(customerId));
        System.out.println("Showing update customer form");
        return "update-customer";
    }

    @RequestMapping("/save-updated-customer")
    public String saveUpdatedCustomer(
            @RequestParam Integer streetNumber,
            @RequestParam String streetName,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String country,
            @RequestParam Integer customerId,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam Integer phoneNumber) throws SQLException {
        Customer customer = agendaManager.findCustomerbyId(customerId);

        customer.setLastName(lastName);
        customer.setFirstName(firstName);
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        Address address = agendaManager.findAddressById(customer.getAddress().getAddressId());
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);

        agendaManager.updateCustomer(customer);
        agendaManager.updateAddress(address);

        return "redirect:/show-customer/" + customer.getCustomerId();

    }

    @RequestMapping("show-customer/{customerId}")
    public String showCustomer(@PathVariable Integer customerId, Model model) throws SQLException {
        model.addAttribute("customer", agendaManager.findCustomerbyId(customerId));
        System.out.println("Showing customer details");
        return "show-customer";
    }

    @RequestMapping("/delete-customer")
    public String deleteCustomer(@RequestParam Integer customerId) throws SQLException {
        Customer customer = agendaManager.findCustomerbyId(customerId);
        agendaManager.deleteCustomerById(customerId);
        return "redirect:/customers";
    }

}
