/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.axyus.agendaSpringWebApp.repository;

import com.axyus.agendaSpringWebApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farah.gauduin
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  

}
