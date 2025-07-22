package com.codemaster.foodCatalogue.controller;

import com.codemaster.foodCatalogue.dto.FoodCataloguePage;
import com.codemaster.foodCatalogue.dto.FoodItemDTO;
import com.codemaster.foodCatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItemInDb(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO savedFoodItem = foodCatalogueService.addFoodItemToDb(foodItemDTO);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    // Get Restaurant and FoodItems endpoints
    @GetMapping("/fetchRestaurantAndFoodItemById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantAndFoodMenu(@PathVariable Integer restaurantId) {
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCatalogueMenu(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }

}
