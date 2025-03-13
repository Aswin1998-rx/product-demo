package com.demo.products.service.usertype;

import com.demo.products.model.UserType;
import com.demo.products.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultUsertypeService implements UserTypeService{

    private final UserTypeRepository repository;

    @Override
    public UserType getUserTypeByType(String type) {
        Optional<UserType> userType;

        try {
            userType = repository.findByType(type);
        }catch (Exception e){
            throw new RuntimeException("failed to fetch user Type");
        }
        return userType.orElseThrow(()->new RuntimeException("user type not found"));
    }
}
