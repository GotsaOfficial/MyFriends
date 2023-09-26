package com.gotsa.socialnetwork.MyFriends.repo;

import com.gotsa.socialnetwork.MyFriends.models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Iterable<Post> findAll(Sort by);
}
