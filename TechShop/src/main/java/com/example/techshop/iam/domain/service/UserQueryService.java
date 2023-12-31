package com.example.techshop.iam.domain.service;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.queries.GetAllUserQuery;
import com.example.techshop.iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    List<User> execute(GetAllUserQuery query);

    Optional<User> execute(GetUserByIdQuery query);
}
