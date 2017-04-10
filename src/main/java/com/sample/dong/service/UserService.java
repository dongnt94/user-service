package com.sample.dong.service;

import java.util.List;

import com.sample.dong.common.ResponseModal;
import com.sample.dong.dto.UserDTO;

public interface UserService {
	ResponseModal getUser(String id);

	ResponseModal getListUser();

	ResponseModal addUser(UserDTO userDto);
}
