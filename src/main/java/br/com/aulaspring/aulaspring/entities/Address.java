package br.com.aulaspring.aulaspring.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

  private String address;
  private String postalCode;
  private String number;
  private String district;
  private String city;

}
