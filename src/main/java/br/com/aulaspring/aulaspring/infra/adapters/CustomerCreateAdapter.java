package br.com.aulaspring.aulaspring.infra.adapters;

import br.com.aulaspring.aulaspring.applications.customer.CustomerCreatePort;
import br.com.aulaspring.aulaspring.entities.Customer;
import br.com.aulaspring.aulaspring.infra.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreateAdapter implements CustomerCreatePort {

  private final CustomerRepository customerRepository;

  public CustomerCreateAdapter(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

}
