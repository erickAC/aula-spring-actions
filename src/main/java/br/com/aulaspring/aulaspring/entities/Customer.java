package br.com.aulaspring.aulaspring.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Setter
@Getter
public class Customer extends BasicEntity {

  private String name;
  private String email;
  private String cellphone;
  @Embedded
  private Address address;
  @OneToMany(mappedBy = "customer")
  public List<Order> orders;

}
