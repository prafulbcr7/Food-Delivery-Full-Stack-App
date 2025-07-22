package com.codemaster.order.repo;

import com.codemaster.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {

}
