package com.practice.catsgram81.service;

import com.practice.catsgram81.exception.PostNotFoundException;
import com.practice.catsgram81.exception.UserNotFoundException;
import com.practice.catsgram81.model.Post;
import com.practice.catsgram81.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final UserService userService;
    private int nextId = 1;
//    {
//        posts.add(new Post("bob", "post1 by bob", "https://photo"));
//    }
    public List<Post> findAll(){
        return posts;
    }
    public Post create(Post post){
        User user = userService.findUserByEmail(post.getAuthor());
        if(user==null){
            throw new UserNotFoundException("такой пользователя нету");
        }
        post.setId(nextId++);
        posts.add(post);
        return post;
    }
    public Post findById(int id){
        for (Post post : posts){
            if (post.getId()==id){
                return post;
            }
        }
       throw new PostNotFoundException("такой пост не найден");
    }

}
