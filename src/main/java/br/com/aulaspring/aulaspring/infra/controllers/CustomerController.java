package br.com.aulaspring.aulaspring.infra.controllers;

import br.com.aulaspring.aulaspring.applications.customer.CustomerCreatePort;
import br.com.aulaspring.aulaspring.applications.customer.CustomerDeletePort;
import br.com.aulaspring.aulaspring.applications.customer.CustomerFindOutbound;
import br.com.aulaspring.aulaspring.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerCreatePort customerCreatePort;
  private final CustomerDeletePort customerDeletePort;

  public CustomerController(CustomerCreatePort customerCreatePort, CustomerDeletePort customerDeletePort) {
    this.customerCreatePort = customerCreatePort;
    this.customerDeletePort = customerDeletePort;
  }

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    Customer result = customerCreatePort.create(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

}
