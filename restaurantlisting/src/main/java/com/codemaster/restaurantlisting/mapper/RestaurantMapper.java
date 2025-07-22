package com.codemaster.restaurantlisting.mapper;

import com.codemaster.restaurantlisting.dto.RestaurantDTO;
import com.codemaster.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// Implementation of this interface will be created automatically by SpringBoot for u
// which will be having all setter and getter and all the mapping of DTO to entiry
// and Entity to DTO.

@Mapper
public interface RestaurantMapper {

    // to use this methods in Service layer we need to create an instance of
    // this RestaurantMapper only.
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    // TWO Abstract Methods.

    // Map RestaurantDTO to Restaurant Entity
    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

    // Map Restaurant Entity to RestaurantDTO
    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
}
