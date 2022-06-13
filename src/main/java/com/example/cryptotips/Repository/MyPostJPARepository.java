package com.example.cryptotips.Repository;

import com.example.cryptotips.Model.MyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPostJPARepository extends JpaRepository<MyPost,Long> {
}
