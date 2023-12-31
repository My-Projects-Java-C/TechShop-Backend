package com.example.techshop.iam.application.internal.queryservices;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.queries.GetAllUserQuery;
import com.example.techshop.iam.domain.model.queries.GetUserByIdQuery;
import com.example.techshop.iam.domain.service.UserQueryService;
import com.example.techshop.iam.infraestructure.persistence.jpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    public List<User> execute(GetAllUserQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> execute(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

}
