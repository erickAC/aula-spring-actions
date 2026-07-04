package br.com.aulaspring.aulaspring.applications.customer;

import java.util.UUID;

import br.com.aulaspring.aulaspring.entities.Customer;

public interface CustomerFindOutbound {

  Customer findById(UUID id);

}
