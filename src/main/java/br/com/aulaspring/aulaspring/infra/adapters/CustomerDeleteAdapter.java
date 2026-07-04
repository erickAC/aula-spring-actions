package br.com.aulaspring.aulaspring.infra.adapters;

import java.util.UUID;

import br.com.aulaspring.aulaspring.applications.customer.CustomerDeletePort;
import br.com.aulaspring.aulaspring.applications.customer.CustomerFindOutbound;
import br.com.aulaspring.aulaspring.entities.Customer;
import br.com.aulaspring.aulaspring.infra.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerDeleteAdapter implements CustomerDeletePort {

  private final CustomerFindOutbound customerFindOutbound;
  private final CustomerRepository customerRepository;

  public CustomerDeleteAdapter(CustomerFindOutbound customerFindOutbound, CustomerRepository customerRepository) {
    this.customerFindOutbound = customerFindOutbound;
    this.customerRepository = customerRepository;
  }
  @Override
  public void delete(UUID id) {
    Customer customer = customerFindOutbound.findById(id);
    customerRepository.delete(customer);
  }
  
}
