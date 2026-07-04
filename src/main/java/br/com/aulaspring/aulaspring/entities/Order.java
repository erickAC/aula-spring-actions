package br.com.aulaspring.aulaspring.entities;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BasicEntity {

  private String code;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "address", column = @Column(name = "delivery_address"))
  })
  private Address address;
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
  @ManyToMany
  @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;

}
