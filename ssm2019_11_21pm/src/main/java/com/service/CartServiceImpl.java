package com.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mapper.CartMapper;
import com.service.CartService;
@Service
public class CartServiceImpl implements CartService{

    @Resource
    private CartMapper cartMapper;

}
