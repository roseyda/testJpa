package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

@DataJpaTest
public class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository customerRepository;

  @Test
  public void sould_retreive_saved_entity_by_fistName() {
    CustomerEntity customerEntity = CustomerEntity.builder()
      .withFirstName("firstName")
      .withLastName("lastName")
      .build();

    CustomerEntity saved = this.customerRepository.save(customerEntity);

    List<CustomerEntity> customerEntities = this.customerRepository.findByFirstName("firstName");

    assertNotNull(customerEntities);
    assertFalse(customerEntities.isEmpty());
    assertEquals(saved, customerEntities.get(0));
  }
}
