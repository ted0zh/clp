package com.learningPlatform.CLP.service.serviceImpl;

import com.learningPlatform.CLP.data.mapper.UserMapper;
import com.learningPlatform.CLP.data.dto.UserDto;
import com.learningPlatform.CLP.data.entity.Users;
import com.learningPlatform.CLP.exceptions.NoSuchUserException;
import com.learningPlatform.CLP.repository.UserRepository;
import com.learningPlatform.CLP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper=userMapper;
    }

    @Override
    public Users createUser(UserDto dto) {
        Users user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Integer id, UserDto dto) throws NoSuchUserException {
         Optional<Users> optionalUser = userRepository.findById(id);
         if(optionalUser.isPresent()){
             Users updatedUser = optionalUser.get();
             updatedUser.setEmail(dto.getEmail());
             updatedUser.setUsername(dto.getUsername());
             updatedUser.setPassword(passwordEncoder.encode(dto.getPassword()));
             updatedUser.setAvatar(dto.getAvatar());
             return userRepository.save(updatedUser);
         }else{
             throw new NoSuchUserException("User with "+id+" not found");
         }
    }

    @Override
    public List<Users> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUser(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users findByUsername(String username) {
       //Optional<Users> userOpt =
        return userRepository.findByUsername(username).get();
    }
}
