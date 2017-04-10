package com.sample.dong.controller;

import com.sample.dong.common.Constants;
import com.sample.dong.common.ResponseModal;
import com.sample.dong.dto.UserDTO;
import com.sample.dong.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.BASE_USER_URL)
public class UserEndpoint {
    @Autowired
    UserService userService;

    @ApiOperation(value = "View user detail", response = UserDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Call successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseModal getUser(@RequestParam("name") String name) {
        return userService.getUser(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseModal getListUser() {
        return userService.getListUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseModal addUser(@RequestBody UserDTO userDto) {
        return userService.addUser(userDto);
    }
}
