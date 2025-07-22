package com.codemaster.order.service;

import com.codemaster.order.dto.OrderDTO;
import com.codemaster.order.dto.OrderDTOFromFE;
import com.codemaster.order.dto.UserDTO;
import com.codemaster.order.entity.Order;
import com.codemaster.order.mapper.OrderMapper;
import com.codemaster.order.repo.OrderRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails){
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDTOFromUserId(orderDetails.getUserId());
        Order order = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        Order savedOrder = orderRepo.save(order);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(savedOrder);
    }

    private UserDTO fetchUserDTOFromUserId(Integer userId){
        return restTemplate.getForObject("http://USER--SERVICE/user/fetchUserById/" +userId, UserDTO.class);
    }
}
