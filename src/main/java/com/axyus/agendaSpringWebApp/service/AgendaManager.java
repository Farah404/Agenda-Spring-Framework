/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.axyus.agendaSpringWebApp.service;

import com.axyus.agendaSpringWebApp.model.Address;
import com.axyus.agendaSpringWebApp.model.Customer;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author farah.gauduin
 */

@Service
public interface AgendaManager {

    public List<Address> getAllAddresses() throws SQLException;

    public Integer createAddress(Address address) throws SQLException;

    public Address updateAddress(Address address) throws SQLException;

    public void deleteAddressById(Integer addressId) throws SQLException;

    public Address findAddressById(Integer addressId) throws SQLException;

    public List<Customer> getAllCustomers() throws SQLException;

    public Integer createCustomer(Customer customer) throws SQLException;

    public Customer updateCustomer(Customer customer) throws SQLException;

    public Customer findCustomerbyId(Integer customerId) throws SQLException;

    public void deleteCustomerById(Integer customerId) throws SQLException;


}
