package com.codemaster.restaurantlisting.service;

import com.codemaster.restaurantlisting.dto.RestaurantDTO;
import com.codemaster.restaurantlisting.entity.Restaurant;
import com.codemaster.restaurantlisting.mapper.RestaurantMapper;
import com.codemaster.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants(){
        List<Restaurant> restaurants =  restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
                .collect(Collectors.toList());
        return restaurantDTOList;
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO){
       Restaurant restaurantSaved  = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
       return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantSaved);
    }

    public ResponseEntity<RestaurantDTO> findRestaurantById(Integer id){
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
