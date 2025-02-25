package com.practice.catsgram81.controller;

import com.practice.catsgram81.model.Post;
import com.practice.catsgram81.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll(){
        return postService.findAll();
    }
    @PostMapping("/posts")
    public Post create(@RequestBody Post post){

        return postService.create(post);
    }
    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }

}
