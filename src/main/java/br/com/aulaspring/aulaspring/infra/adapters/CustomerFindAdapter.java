package br.com.aulaspring.aulaspring.infra.adapters;

import java.util.UUID;

import br.com.aulaspring.aulaspring.applications.customer.CustomerFindOutbound;
import br.com.aulaspring.aulaspring.entities.Customer;
import br.com.aulaspring.aulaspring.infra.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerFindAdapter implements CustomerFindOutbound {

  private final CustomerRepository customerRepository;

  public CustomerFindAdapter(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer findById(UUID id) {
    return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Clienten não encontrado!"));
  }
}
