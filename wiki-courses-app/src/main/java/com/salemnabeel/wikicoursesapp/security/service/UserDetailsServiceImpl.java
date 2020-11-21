package com.salemnabeel.wikicoursesapp.security.service;

import com.salemnabeel.wikicoursesapp.security.model.User;
import com.salemnabeel.wikicoursesapp.security.model.MyUserDetails;
import com.salemnabeel.wikicoursesapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.getUserByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("[" + userName + "] could not found."));

        return new MyUserDetails(user.get());
    }
}