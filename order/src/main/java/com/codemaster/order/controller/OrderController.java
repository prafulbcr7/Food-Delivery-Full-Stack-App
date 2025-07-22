package com.codemaster.order.controller;

import com.codemaster.order.dto.OrderDTO;
import com.codemaster.order.dto.OrderDTOFromFE;
import com.codemaster.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
        OrderDTO orderSaved = orderService.saveOrderInDB(orderDetails);
        return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);

    }
}
