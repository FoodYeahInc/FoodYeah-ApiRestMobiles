package com.example.repository;

import com.example.entity.Card;
import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

   List<Card> findByCustomer(Customer customer);

}
