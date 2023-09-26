package com.gotsa.socialnetwork.MyFriends.controllers;

import com.gotsa.socialnetwork.MyFriends.models.User;
import com.gotsa.socialnetwork.MyFriends.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable(value = "id") long id, Model model) {
        if(!userRepository.existsById(id)) {
            return "redirect:/profile/1";
        }

        Optional<User> user = userRepository.findById(id);
        ArrayList<User> userArrayList = new ArrayList<>();
        user.ifPresent(userArrayList::add);
        String username = "MF | " + userArrayList.get(0).getUsername();
        model.addAttribute("username", username);
        model.addAttribute("user", userArrayList);

        return "profile/profile";
    }
}
