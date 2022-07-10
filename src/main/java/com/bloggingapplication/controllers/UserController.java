package com.bloggingapplication.controllers;

import com.bloggingapplication.payloads.ApiResponse;
import com.bloggingapplication.payloads.UserDTO;
import com.bloggingapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity createUser(@Valid @RequestBody UserDTO userDTO)
    {
            UserDTO user=userService.createUser(userDTO);
            return new ResponseEntity(new ApiResponse("User Created Successfully!!",true), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("userId") Integer userId)
    {
        UserDTO user=userService.updateUser(userDTO,userId);
        ResponseEntity responseEntity = new ResponseEntity(new ApiResponse("User Updated Successfully!!", true), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
    {
        userService.deleteUser(userId);
        ResponseEntity<ApiResponse> apiResponseResponseEntity = new ResponseEntity<>(new ApiResponse("User Deleted Successfully!!", true), HttpStatus.OK);
        return apiResponseResponseEntity;

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> allUsers=userService.getAllUsers();
        return new ResponseEntity(allUsers,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getAUser(@PathVariable Integer userId)
    {
        UserDTO userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }
}
