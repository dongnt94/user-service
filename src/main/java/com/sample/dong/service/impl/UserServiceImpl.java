package com.sample.dong.service.impl;

import com.sample.dong.common.ResponseModal;
import com.sample.dong.dto.UserDTO;
import com.sample.dong.mapper.UserMapper;
import com.sample.dong.repository.UserRepository;
import com.sample.dong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //@Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseModal getUser(String name) {
        ResponseModal getUser = new ResponseModal(200, "Success");
        if (userRepository.findByName(name).isPresent()) {
            getUser.setData(userRepository.findByName(name).get());
            return getUser;
        }
        getUser.setCode(404);
        getUser.setMsg("User not found");
        return getUser;
    }

    @Override
    public ResponseModal getListUser() {
        ResponseModal getUser = new ResponseModal(200, "Success");
        getUser.setData(userRepository.findAll());
        return getUser;
    }

    @Override
    public ResponseModal addUser(UserDTO userDto) {
        ResponseModal getUser = new ResponseModal(200, "Success");
        if (!userRepository.findByName(userDto.getName()).isPresent()) {
            userRepository.save(userMapper.toEntity(userDto));
            getUser.setData(userRepository.findByName(userDto.getName()).get());
            return getUser;
        }
        getUser.setCode(500);
        getUser.setMsg("User existed");
        return getUser;
    }
}
