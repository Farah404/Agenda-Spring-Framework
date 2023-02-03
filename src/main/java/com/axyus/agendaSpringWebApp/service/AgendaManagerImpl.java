/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axyus.agendaSpringWebApp.service;

import com.axyus.agendaSpringWebApp.model.Address;
import com.axyus.agendaSpringWebApp.model.Customer;
import com.axyus.agendaSpringWebApp.repository.AddressRepository;
import com.axyus.agendaSpringWebApp.repository.CustomerRepository;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farah.gauduin
 */
@Service
public class AgendaManagerImpl implements AgendaManager {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Address> getAllAddresses() throws SQLException {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Integer createAddress(Address address) throws SQLException {
        addressRepository.save(address);
        return address.getAddressId();
    }

    @Override
    public Address updateAddress(Address address) throws SQLException {
        addressRepository.save(address);
        return address;
    }

    @Override
    public void deleteAddressById(Integer addressId) throws SQLException {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Address findAddressById(Integer addressId) throws SQLException {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Integer createCustomer(Customer customer) throws SQLException {
        customerRepository.save(customer);
        return customer.getCustomerId();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws SQLException {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer findCustomerbyId(Integer customerId) throws SQLException {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(Integer customerId) throws SQLException {
        customerRepository.deleteById(customerId);
    }


}
