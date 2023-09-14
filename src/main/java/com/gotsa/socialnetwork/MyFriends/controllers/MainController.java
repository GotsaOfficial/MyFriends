package com.gotsa.socialnetwork.MyFriends.controllers;

import com.gotsa.socialnetwork.MyFriends.models.User;
import com.gotsa.socialnetwork.MyFriends.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "test");
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "test");
        Iterable<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("users", users);
        return "admin/test";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String text, Model model) {
        return "authentication/login";
    }
}
