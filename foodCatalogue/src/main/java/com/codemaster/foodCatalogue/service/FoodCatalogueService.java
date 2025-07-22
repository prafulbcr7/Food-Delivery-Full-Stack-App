package com.codemaster.foodCatalogue.service;

import com.codemaster.foodCatalogue.dto.FoodCataloguePage;
import com.codemaster.foodCatalogue.dto.FoodItemDTO;
import com.codemaster.foodCatalogue.dto.Restaurant;
import com.codemaster.foodCatalogue.entity.FoodItem;
import com.codemaster.foodCatalogue.mapper.FoodItemMapper;
import com.codemaster.foodCatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItemToDb(FoodItemDTO foodItemDTO){
        FoodItem foodItemSavedToDb= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedToDb);
    }

    public FoodCataloguePage fetchFoodCatalogueMenu(Integer restaurantId){
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantService(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantService(Integer id) {
        return restTemplate.getForObject("http://RESTAURANT--SERVICE/restaurant/fetchById/"+id, Restaurant.class);
    }
}
