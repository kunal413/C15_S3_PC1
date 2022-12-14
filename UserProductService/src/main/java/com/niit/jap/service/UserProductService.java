package com.niit.jap.service;

import com.niit.jap.domain.Product;
import com.niit.jap.domain.User;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.rabbitmq.CommonUser;

public interface UserProductService {
    User addUser(User user) throws UserNotFoundException;
    User addProductForUser(int UserId, Product product) throws UserNotFoundException;
    User deleteProductForUser(int userId,int productId)throws UserNotFoundException;
    User addUser1(CommonUser commonUser);

}
