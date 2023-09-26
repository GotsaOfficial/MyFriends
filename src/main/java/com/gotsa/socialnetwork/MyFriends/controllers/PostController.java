package com.gotsa.socialnetwork.MyFriends.controllers;

import com.gotsa.socialnetwork.MyFriends.models.Post;
import com.gotsa.socialnetwork.MyFriends.models.User;
import com.gotsa.socialnetwork.MyFriends.repo.PostRepository;
import com.gotsa.socialnetwork.MyFriends.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/post/{id}")
    public String postpage(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/profile/1";
        }

        Post postV = postRepository.findById(id).orElseThrow();
        postV.setViews(postV.getViews() + 1);
        postRepository.save(postV);

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> postArrayList = new ArrayList<>();
        post.ifPresent(postArrayList::add);
        model.addAttribute("post", postArrayList.get(0));

        return "profile/post";
    }

    @GetMapping("/post/add")
    public String getPostadd() {
        return "profile/postadd";
    }

    @PostMapping("/post/add")
    public String postPostadd(@RequestParam String title, @RequestParam String text, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Post post = new Post(title, text, customUserDetails.getUser());
        postRepository.save(post);
        return "redirect:/profile/"+customUserDetails.getId();
    }

    @GetMapping("/post/{id}/edit")
    public String getPostpageedit(@PathVariable(value = "id") long id, Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        if(!postRepository.existsById(id)) {
            return "redirect:/profile/1";
        }

        Post postcheck = postRepository.findById(id).orElseThrow();
        if (!Objects.equals(postcheck.getOwner().getId(), customUserDetails.getId())) {
            System.out.println("Not Your Profile. Redicecting....");
            return "redirect:/post/" + id;
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> postArrayList = new ArrayList<>();
        post.ifPresent(postArrayList::add);
        model.addAttribute("post", postArrayList.get(0));

        return "profile/postedit";
    }

    @PostMapping("/post/{id}/edit")
    public String postPostpageedit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String text, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        if(!postRepository.existsById(id)) {
            return "redirect:/profile/1";
        }

        Post post = postRepository.findById(id).orElseThrow();
        if (Objects.equals(post.getOwner().getId(), customUserDetails.getId())) {
            post.setTitle(title);
            post.setText(text);
            if (text.length() > 64) {
                post.setMini_text(text.substring(0, 50) + ".....");
            }else {
                post.setMini_text("");
            }
            postRepository.save(post);
        } else {
            System.out.println("Not Your Profile");
        }
        return "redirect:/post/" + id;
    }
}
