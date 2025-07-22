package com.codemaster.foodCatalogue.dto;

import com.codemaster.foodCatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

    Restaurant restaurant;

    List<FoodItem> foodItemsList;
}
