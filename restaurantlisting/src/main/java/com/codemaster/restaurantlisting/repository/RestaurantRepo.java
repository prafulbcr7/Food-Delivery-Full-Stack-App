package com.codemaster.restaurantlisting.repository;

import com.codemaster.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // It will create a bean for this RestaurantRepo which we can easily Autowire in our service Layer
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
