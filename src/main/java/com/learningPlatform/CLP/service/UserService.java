package com.learningPlatform.CLP.service;

import com.learningPlatform.CLP.data.dto.UserDto;
import com.learningPlatform.CLP.data.entity.Users;
import com.learningPlatform.CLP.exceptions.NoSuchUserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
   Users createUser(UserDto dto);
   Users updateUser(Integer id, UserDto dto) throws NoSuchUserException;
   List<Users> fetchUsers();
   Optional<Users> getUser(Integer id);
   void deleteUser(Integer id);
   Users findByUsername(String username);

}
