package com.example.mariushop.services;


import com.example.mariushop.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    @Transactional
    public void  deleteById(Integer id, String userName){
        cartRepository.deleteCartByProductIdAndUser_Username(id,userName);
    }

    @Transactional
    public void deleteByUser(String username){
        cartRepository.deleteCartByUser_Username(username);
    }
}
