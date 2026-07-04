package br.com.aulaspring.aulaspring.applications.customer;

import br.com.aulaspring.aulaspring.entities.Address;
import br.com.aulaspring.aulaspring.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class CustomerDeletePortTest {

  @Container
  @ServiceConnection
  private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer("postgres:latest");

  @Autowired
  private CustomerDeletePort customerDeletePort;

  @Autowired
  private CustomerCreatePort customerCreatePort;

  @Test
  void delete() {
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

    assertThatNoException().isThrownBy(() -> customerDeletePort.delete(result.getId()));
  }
}