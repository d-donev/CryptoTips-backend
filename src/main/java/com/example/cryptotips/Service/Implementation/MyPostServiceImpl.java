package com.example.cryptotips.Service.Implementation;

import com.example.cryptotips.Model.Comparator.SortByDateAdded;
import com.example.cryptotips.Model.DTO.PostDTO;
import com.example.cryptotips.Model.Exceptions.CreateArgumentNotGivenException;
import com.example.cryptotips.Model.Exceptions.EditArgumentNotGivenException;
import com.example.cryptotips.Model.Exceptions.PostNotFoundException;
import com.example.cryptotips.Model.MyPost;
import com.example.cryptotips.Repository.MyPostJPARepository;
import com.example.cryptotips.Service.MyPostService;
import org.attoparser.dom.Text;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MyPostServiceImpl implements MyPostService {

    private final MyPostJPARepository myPostRepository;

    public MyPostServiceImpl(MyPostJPARepository myPostRepository) {
        this.myPostRepository = myPostRepository;
    }


    @Override
    public MyPost findById(Long id) {
        return myPostRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public List<MyPost> findAll() {
        List<MyPost> myPostList = myPostRepository.findAll();
        myPostList.sort(new SortByDateAdded().reversed());
        return myPostList;
    }


    @Override
    public Optional<MyPost> createWithDto(PostDTO postDTO) {
        MyPost myPost = new MyPost(postDTO.getTitle(), postDTO.getDescription(), postDTO.getImage());
        return Optional.of(myPostRepository.save(myPost));
    }

    @Override
    public MyPost edit(Long id, String title, String description, String image) {
        MyPost myPost = this.findById(id);
        if (title.isEmpty()  || image.isEmpty()) {
            throw new EditArgumentNotGivenException();
        }
        myPost.setTitle(title);
        myPost.setDescription(description);
        myPost.setImage(image);
        myPost.setDateAdded(LocalDateTime.now());
        return myPostRepository.save(myPost);
    }

    @Override
    public Optional<MyPost> editWithDto(Long id, PostDTO postDTO) {

        MyPost myPost = this.findById(id);
        if (postDTO == null) {
            throw new EditArgumentNotGivenException();
        }
        myPost.setTitle(postDTO.getTitle());
        myPost.setDescription(postDTO.getDescription());
        myPost.setImage(postDTO.getImage());
        myPost.setDateAdded(LocalDateTime.now());
        return Optional.of(myPostRepository.save(myPost));
    }

    @Override
    public Optional<MyPost> delete(Long id) {
        MyPost myPost = this.findById(id);
        myPostRepository.delete(myPost);
        return Optional.of(myPost);
    }
}
