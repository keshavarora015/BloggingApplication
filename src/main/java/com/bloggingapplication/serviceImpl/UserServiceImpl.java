package com.bloggingapplication.serviceImpl;

import com.bloggingapplication.entities.User;
import com.bloggingapplication.exceptions.ResourceNotFoundException;
import com.bloggingapplication.payloads.UserDto;
import com.bloggingapplication.repositories.UserRepo;
import com.bloggingapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = userDtoToUser(userDTO);
        user=userRepo.save(user);
        return userToUserDTO(user) ;
    }

    @Override
    public UserDto updateUser(UserDto userDTO, Integer id) {

        User user = null;
        try{
            user=userRepo.getReferenceById(id);

            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setAbout(userDTO.getAbout());

            user=userRepo.save(user);
        }
        catch (ResourceNotFoundException e)
        {
                throw new ResourceNotFoundException("User","UserId",Long.parseLong(String.valueOf(id)));
        }
        return userToUserDTO(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user;
        try
        {
            user=userRepo.getReferenceById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("User","UserId",Long.parseLong(String.valueOf(id)));
        }
        return userToUserDTO(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepo.findAll();

        List<UserDto> userDTOS=users.stream().map(user ->userToUserDTO(user)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public void deleteUser(Integer Id) {
        User user;
        try
        {
            user=userRepo.getReferenceById(Id);
            userRepo.delete(user);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("User","UserId",Long.parseLong(String.valueOf(Id)));
        }
    }

    private User userDtoToUser(UserDto userDTO)
    {
        User user=this.modelMapper.map(userDTO,User.class);
    //       User user=new User();
    //       user.setId(userDTO.getId());
    //       user.setName(userDTO.getName());
    //       user.setEmail(userDTO.getEmail());
    //       user.setPassword(userDTO.getPassword());
    //       user.setAbout(userDTO.getAbout());
       return user;
    }

    private UserDto userToUserDTO(User user)
    {
        UserDto userDTO=this.modelMapper.map(user, UserDto.class);
//        UserDto userDTO=new UserDto();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAbout(user.getAbout());
        return userDTO;

    }
}