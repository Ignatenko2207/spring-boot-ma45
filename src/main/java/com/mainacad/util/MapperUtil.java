package com.mainacad.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainacad.dao.UserDAO;
import com.mainacad.model.Cart;
import com.mainacad.model.CartStatus;
import com.mainacad.model.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ObjectMapper objectMapper;

    public Cart toCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setUser(userDAO.getOne(cartDTO.getUserId()));
        cart.setStatus(CartStatus.valueOf(cartDTO.getStatus().toUpperCase()));
        cart.setCreationTime(cartDTO.getCreationTime());
        return  cart;
    }


    public CartDTO toCartDTO(String request) {
        try {
            return objectMapper.readValue(request, CartDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
