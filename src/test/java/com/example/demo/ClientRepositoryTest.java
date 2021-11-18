package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.id.ClientEntityId;
import com.example.demo.repository.ClientRepository;

@DataJpaTest
public class ClientRepositoryTest {

  @Autowired
  private ClientRepository clientRepository;

  @Test
  public void sould_retreive_saved_entity_by_fistName() {
    ClientEntity clientEntity = ClientEntity.builder()
      .withId(ClientEntityId.builder()
        .withFirstName("firstName")
        .withLastName("lastName")
        .build())
      .build();

    ClientEntity saved = this.clientRepository.save(clientEntity);

    List<ClientEntity> clientEntities = this.clientRepository.findByFirstName("firstName");

    assertNotNull(clientEntities);
    assertFalse(clientEntities.isEmpty());
    assertEquals(saved, clientEntities.get(0));
  }
}
