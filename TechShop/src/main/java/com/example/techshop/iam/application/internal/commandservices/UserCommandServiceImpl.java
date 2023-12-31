package com.example.techshop.iam.application.internal.commandservices;

import com.example.techshop.iam.application.internal.outboundservices.hashing.HashingService;
import com.example.techshop.iam.application.internal.outboundservices.tokens.TokenService;
import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.commands.AddRolesCommand;
import com.example.techshop.iam.domain.model.commands.SignInCommand;
import com.example.techshop.iam.domain.model.commands.SignUpCommand;
import com.example.techshop.iam.domain.model.valueobjects.Roles;
import com.example.techshop.iam.domain.service.UserCommandService;
import com.example.techshop.iam.infraestructure.persistence.jpa.repositories.RoleRepository;
import com.example.techshop.iam.infraestructure.persistence.jpa.repositories.UserRepository;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.interfaces.acl.ProfileContextFacade;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final ProfileContextFacade profileContextFacade;

    private final UserRepository userRepository;

    private final HashingService hashingService;

    private final TokenService tokenService;

    private final RoleRepository roleRepository;

    @Override
    public Optional<User> execute(SignUpCommand command) {
        if(userRepository.existsByEmail(command.email())){
            throw new RuntimeException("Username already exists");
        }
        var roles = command.roles().stream().map(
                    role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role name not found")))
                    .collect(Collectors.toList());
        if (roles.isEmpty()) {
            roles.add(roleRepository.findByName(Roles.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException("Default role not found")));
        }
        var profile = profileContextFacade.createProfile(
                command.name(), command.lastName(), command.identityDocument(), command.location());
        if (profile.isEmpty()) {
            throw new RuntimeException("Profile has not been created");
        }
        var user = new User(command.email(), hashingService.encode(command.password()), roles, profile.get());
        userRepository.save(user);
        return Optional.of(user);
    }
    @Override
    public Optional<ImmutablePair<User, String>> execute(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        if (!hashingService.matches(command.password(), user.get().getPassword())){
            throw new RuntimeException("Invalid password");
        }
        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
    @Override
    public Optional<User> execute(AddRolesCommand command) {
        var user = userRepository.findByEmail(command.email()).orElseThrow(()-> new RuntimeException("User not found"));
        var newRole =roleRepository.findByName(Roles.valueOf(command.roleName())).orElseThrow(()-> new RuntimeException("The user can't add this role"));
        if(!user.getRoles().contains(newRole)){
            user.getRoles().add(newRole);
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }


}
