package com.an_moudou.services;

import com.an_moudou.entities.Users;
import com.an_moudou.exception.ResourceNotFoundException;
import com.an_moudou.security.UserPrincipal;
import com.an_moudou.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Users users = usersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return UserPrincipal.create(users);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(users);
    }
}
