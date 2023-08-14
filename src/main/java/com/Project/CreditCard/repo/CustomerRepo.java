package com.Project.CreditCard.repo;


import com.Project.CreditCard.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepo  extends MongoRepository<Customer, ObjectId> {

    List<Customer> findByGender(String Gender);
    List<Customer> findByProfession(String profession);



    //Page<Customer> findByGreaterThan(double salary, Pageable pageable);
    //Page<Customer> findAll(Pageable pageable);





}
