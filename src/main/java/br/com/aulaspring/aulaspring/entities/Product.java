package br.com.aulaspring.aulaspring.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BasicEntity {

  private String name;
  private BigDecimal value;
}
