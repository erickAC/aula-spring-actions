package br.com.aulaspring.aulaspring.entities;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BasicEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

}
