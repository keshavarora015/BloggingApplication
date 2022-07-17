package com.bloggingapplication.services;

import com.bloggingapplication.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDTO);

    UserDto updateUser(UserDto userDTO, Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    void deleteUser(Integer Id);
}
