package com.gotsa.socialnetwork.MyFriends.controllers;

import com.gotsa.socialnetwork.MyFriends.models.Post;
import com.gotsa.socialnetwork.MyFriends.models.Role;
import com.gotsa.socialnetwork.MyFriends.models.Status;
import com.gotsa.socialnetwork.MyFriends.models.User;
import com.gotsa.socialnetwork.MyFriends.repo.UserRepository;
import com.gotsa.socialnetwork.MyFriends.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "authentication/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "authentication/logout";
    }

    @GetMapping("/signup")
    public String signup() {
        return "authentication/signup";
    }

    @PostMapping("/signup")
    public String signuppost(
            @RequestParam String username, @RequestParam String password,
            @RequestParam String email, @RequestParam String first_name, @RequestParam String last_name,
            @RequestParam String tel, @RequestParam String address, @RequestParam LocalDate b_day) {
        User user = new User(username, password, email, first_name, last_name, tel, address, b_day);
        customUserDetailsService.createNewUser(user);
        Optional<User> userOptional = userRepository.findByUsername(username);
        ArrayList<User> userArrayList = new ArrayList<>();
        userOptional.ifPresent(userArrayList::add);
        Long id = userArrayList.get(0).getId();

        return ("redirect:/profile/"+id);
    }
}
