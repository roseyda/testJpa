package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

  @Query("SELECT c FROM CustomerEntity c WHERE c.firstName = :firstName")
  List<CustomerEntity> findByFirstName(@Param("firstName") String firstName);

}
