package com.root.main.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.root.main.models.User;

@Repository
public interface UserDataPagingRepository extends PagingAndSortingRepository<User, Integer> {

}
