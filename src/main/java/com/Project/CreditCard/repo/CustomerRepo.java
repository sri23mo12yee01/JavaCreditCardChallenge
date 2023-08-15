package com.Project.CreditCard.repo;


import com.Project.CreditCard.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo  extends MongoRepository<Customer, ObjectId> {

    List<Customer> findByGender(String Gender);
    List<Customer> findByProfession(String profession);

  @Query("{customerId}:?0")
    Customer findByCustomerId(String id);


    @Query("{customerId}:?0")
    void deleteByCustomerId(String id);


    //Page<Customer> findByGreaterThan(double salary, Pageable pageable);
    //Page<Customer> findAll(Pageable pageable);





}
