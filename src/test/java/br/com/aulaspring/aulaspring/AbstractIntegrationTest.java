package br.com.aulaspring.aulaspring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;

@SpringBootTest
@ImportTestcontainers
public abstract class AbstractIntegrationTest {

  @Container
  @ServiceConnection
  private static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:16-alpine")
      .withReuse(true);

}
