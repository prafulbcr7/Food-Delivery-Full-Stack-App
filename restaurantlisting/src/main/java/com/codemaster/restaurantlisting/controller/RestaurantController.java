package com.codemaster.restaurantlisting.controller;

import com.codemaster.restaurantlisting.dto.RestaurantDTO;
import com.codemaster.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // combination of @Controller and @ResponseBody - this makes sure the responses are all in JSON format and not in JSP,etc
@RequestMapping("/restaurant") // to annotate this controller with base path/URL - 'restaurant'
public class RestaurantController {

    @Autowired // we always autowired the Service Layer
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    // Fetch Restaurant By Id
    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id){
        return restaurantService.findRestaurantById(id);
    }

}
