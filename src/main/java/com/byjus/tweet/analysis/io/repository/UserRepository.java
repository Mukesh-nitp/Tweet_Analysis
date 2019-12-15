package com.byjus.tweet.analysis.io.repository;

import com.byjus.tweet.analysis.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findUserByUserId(String userId);
}
