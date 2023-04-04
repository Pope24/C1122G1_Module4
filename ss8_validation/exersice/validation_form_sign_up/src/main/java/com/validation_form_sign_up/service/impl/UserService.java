package com.validation_form_sign_up.service.impl;

import com.validation_form_sign_up.model.User;
import com.validation_form_sign_up.repository.IUserRepository;
import com.validation_form_sign_up.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
