package com.gotsa.socialnetwork.MyFriends.service;

import com.gotsa.socialnetwork.MyFriends.models.Role;
import com.gotsa.socialnetwork.MyFriends.models.User;
import com.gotsa.socialnetwork.MyFriends.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' Not Found", username)
        ));

        return new CustmoUserDetails(user);
    }

    public void createNewUser(User user) {
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
