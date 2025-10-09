package com.example_jpa_h2_demo.jpa_h2_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example_jpa_h2_demo.jpa_h2_demo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
