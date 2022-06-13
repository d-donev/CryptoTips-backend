package com.example.cryptotips.Controller;

import com.example.cryptotips.Model.DTO.PostDTO;
import com.example.cryptotips.Model.MyPost;
import com.example.cryptotips.Service.MyPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class MyPostRestController {

    private final MyPostService myPostService;

    public MyPostRestController(MyPostService myPostService) {
        this.myPostService = myPostService;
    }

    @GetMapping("/post")
    public List<MyPost> getAllPosts() {
        return myPostService.findAll();
    }

    @GetMapping("/post/{id}")
    public MyPost getById(@PathVariable  Long id) {
        return myPostService.findById(id);
    }

    @PostMapping("/post/add")
    public ResponseEntity<MyPost> addPost(@RequestBody PostDTO postDTO) {
        return myPostService.createWithDto(postDTO)
                .map(post -> ResponseEntity.ok().body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/post/edit/{id}")
    public ResponseEntity<MyPost> editPost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return myPostService.editWithDto(id,postDTO)
                .map(post -> ResponseEntity.ok().body(post))
                .orElseGet(()  -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<MyPost> deletePost (@PathVariable Long id) {
        return myPostService.delete(id)
                .map(post -> ResponseEntity.ok().body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
