package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.id.ClientEntityId;

public interface ClientRepository extends JpaRepository<ClientEntity, ClientEntityId> {

  @Query("SELECT c FROM ClientEntity c WHERE c.id.firstName = :firstName")
  List<ClientEntity> findByFirstName(@Param("firstName") String firstName);

}
