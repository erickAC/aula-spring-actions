package br.com.aulaspring.aulaspring.applications.customer;

import java.util.UUID;

import br.com.aulaspring.aulaspring.AbstractIntegrationTest;
import br.com.aulaspring.aulaspring.entities.Address;
import br.com.aulaspring.aulaspring.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerFindOutboundTest extends AbstractIntegrationTest {

  @Autowired
  private CustomerCreatePort customerCreatePort;

  @Autowired
  private CustomerFindOutbound customerFindOutbound;

  private UUID customerId;

  @BeforeEach
  void setUp() {
    Address address = new Address();
    address.setAddress("Rua fulando de tal");
    address.setPostalCode("17550000");
    address.setCity("New York");
    address.setDistrict("New York");
    address.setNumber("1231");

    Customer customer = new Customer();
    customer.setName("Erick");
    customer.setEmail("cerickandrade@gmail.com");
    customer.setAddress(address);

    Customer result = customerCreatePort.create(customer);
    customerId = result.getId();
  }

  @Test
  void findById() {
    Customer result = customerFindOutbound.findById(customerId);

    assertThat(result.getName()).isEqualTo("Erick");
    assertThat(result.getEmail()).isEqualTo("cerickandrade@gmail.com");
    assertThat(result.getCellphone()).isNull();
    assertThat(result.getAddress()).isInstanceOf(Address.class).satisfies(address -> {
      assertThat(address.getCity()).isEqualToIgnoringCase("New york");
    });
  }
}