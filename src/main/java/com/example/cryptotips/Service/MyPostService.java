package com.example.cryptotips.Service;

import com.example.cryptotips.Model.DTO.PostDTO;
import com.example.cryptotips.Model.MyPost;
import org.attoparser.dom.Text;

import java.util.List;
import java.util.Optional;

public interface MyPostService {

    MyPost findById(Long id);

    List<MyPost> findAll();

    Optional<MyPost> createWithDto (PostDTO postDTO);

    MyPost edit(Long id, String title, String description, String image);

    Optional<MyPost> editWithDto (Long id, PostDTO postDTO);

    Optional<MyPost> delete(Long id);

}
