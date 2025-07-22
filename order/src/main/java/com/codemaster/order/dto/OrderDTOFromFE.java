package com.codemaster.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {

    private Integer UserId;
    private Restaurant restaurant;
    private List<FoodItemsDTO> foodItemsList;
}
