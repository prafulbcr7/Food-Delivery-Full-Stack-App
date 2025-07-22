package com.codemaster.restaurantlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*

	This Restaurant Microservice is responsible for listing all
	restaurants in the frontEnd UI.

   --> @in CRUD and Rest Endpoints for getAllRestaurants()/ fetch all and put it in
           front-end UI.
   --> @in getRestaurantById() used by Food Listing Service to fetch all food
           items from that particular restaurant.

    ** Lombok - reducing getter and setter boilerplate code.
    ** Eureka Client - to Make this register to the Eureka Server
    ** MapStruct - to map the Entities to DTOs(Data Transfer Object) and vice versa.


    Notes:-
     -- @Repo Layer - Where we have only and only all we have all connections with
              Database, and no interaction with client or the Business Logic.
     -- In Real IT world u will always interact with consumers with DTO and will not
              entities interacting.
         Example: DTO's - we should never interact with clients with real entity, so
              getting a restaurant enrity to save it in DB or to return a restaurant
              entity, never work with Entity.
 */

@SpringBootApplication
public class RestaurantlistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantlistingApplication.class, args);
	}

}
