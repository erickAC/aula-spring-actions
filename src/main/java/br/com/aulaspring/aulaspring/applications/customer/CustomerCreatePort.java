package br.com.aulaspring.aulaspring.applications.customer;

import br.com.aulaspring.aulaspring.entities.Customer;

public interface CustomerCreatePort {
  Customer create(Customer customer);
}
