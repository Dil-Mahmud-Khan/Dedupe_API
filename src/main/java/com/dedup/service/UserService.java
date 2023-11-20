package com.dedup.service;

import com.dedup.exception.DuplicateUserException;
import com.dedup.model.UserInfo;
import com.dedup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        if (userRepository.existsByFirstName(userInfo.getFirstName())) {
            throw new DuplicateUserException(true);
        }
        if (userRepository.existsByNid(userInfo.getNid())) {
            throw new DuplicateUserException(true);
        }
        return userRepository.save(userInfo);
    }
}
