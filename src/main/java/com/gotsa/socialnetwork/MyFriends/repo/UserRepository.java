package com.gotsa.socialnetwork.MyFriends.repo;

import com.gotsa.socialnetwork.MyFriends.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findAll(Sort by);
    Optional<User> findByUsername(String username);
}
