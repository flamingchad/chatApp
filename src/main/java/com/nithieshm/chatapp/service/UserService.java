package com.nithieshm.chatapp.service;

import com.nithieshm.chatapp.dto.UserLoginDTO;
import com.nithieshm.chatapp.dto.UserRegistrationDTO;
import com.nithieshm.chatapp.model.User;
import com.nithieshm.chatapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
       this.passwordEncoder = new BCryptPasswordEncoder();
   }

   public void registerUser(UserRegistrationDTO userRegistrationDTO) {
       if (userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {
           throw new RuntimeException("User already exists");
       }

       User user = new User();
       user.setEmail(userRegistrationDTO.getEmail());
       user.setFirstName(userRegistrationDTO.getFirstName());
       user.setLastName(userRegistrationDTO.getLastName());

       user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

       userRepository.save(user);
   }

   public void loginUser(UserLoginDTO userLoginDTO) {
       if (userRepository.findByEmail(userLoginDTO.getEmail()).isEmpty()) {
           throw new RuntimeException("User not found");
       }

       Optional<User> user = userRepository.findByEmail(userLoginDTO.getEmail());
       if (user.isPresent() && passwordEncoder.matches(userLoginDTO.getPassword(), user.get().getPassword())) {

       }
   }
}
