package br.com.aulaspring.aulaspring.infra.repositories;

import java.util.UUID;

import br.com.aulaspring.aulaspring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> { }
