package com.niit.jap.service;

import com.niit.jap.domain.Product;
import com.niit.jap.domain.User;
import com.niit.jap.exception.ProductNotFoundException;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.rabbitmq.CommonUser;
import com.niit.jap.rabbitmq.Producer;
import com.niit.jap.rabbitmq.UserDTO;
import com.niit.jap.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserProductServiceImpl implements UserProductService{
    @Autowired
    private UserProductRepository userProductRepository;
    @Autowired
    private Producer producer;

    @Override
    public User addUser(User user) throws UserNotFoundException {
        if (userProductRepository.findById(user.getUserId()).isPresent()){
            throw new UserNotFoundException();
        }
        return userProductRepository.insert(user);
    }

    @Override
    public User addProductForUser(int userId, Product product) throws UserNotFoundException {
        if (userProductRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userProductRepository.findByUserId(userId);
        if (user.getProductList()==null){
            user.setProductList(Arrays.asList(product));
        }
        else {
            List<Product>products=user.getProductList();
            products.add(product);
            user.setProductList(products);
        }
        return userProductRepository.save(user);
    }

    @Override
    public User deleteProductForUser(int userId, int productId) throws UserNotFoundException {
        boolean productIdIsPresent = false;
        if(userProductRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userProductRepository.findById(userId).get();
        List<Product> products = user.getProductList();
        productIdIsPresent = products.removeIf(x->x.equals(productId));
        if(!productIdIsPresent)
        {
            throw new UserNotFoundException();
        }
        user.setProductList(products);
        return userProductRepository.save(user);
    }

    @Override
    public User addUser1(CommonUser commonUser) {
        UserDTO userDTO = new UserDTO(commonUser.getEmailId(),commonUser.getUserPassword());
        producer.sendDtoToQueue(userDTO);
        User user = new User(commonUser.getUserId(), commonUser.getEmailId(), commonUser.getUserName(), commonUser.getPhoneNo(), new ArrayList<>());
        return userProductRepository.insert(user);
    }

}
