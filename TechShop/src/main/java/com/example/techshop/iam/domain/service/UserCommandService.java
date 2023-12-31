package com.example.techshop.iam.domain.service;


import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.commands.AddRolesCommand;
import com.example.techshop.iam.domain.model.commands.SignInCommand;
import com.example.techshop.iam.domain.model.commands.SignUpCommand;
import com.example.techshop.iam.domain.model.entities.Role;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserCommandService {
    Optional<User> execute(SignUpCommand command);

    Optional<ImmutablePair<User, String>> execute(SignInCommand command);

    Optional<User> execute(AddRolesCommand command);
}
