package com.example.techshop.iam.application.internal.commandservices;

import com.example.techshop.iam.domain.model.commands.GetDefaultRoleCommand;
import com.example.techshop.iam.domain.model.commands.SeedRolesCommand;
import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.domain.model.valueobjects.Roles;
import com.example.techshop.iam.domain.service.RoleCommandService;
import com.example.techshop.iam.infraestructure.persistence.jpa.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    /** this method will handle the {@link SeedRolesCommand} and will create the roles if not exists
     * @param command {@link SeedRolesCommand}
     * @see SeedRolesCommand
     * */

    @Override
    public void execute(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(
                role -> {
                    if (!roleRepository.existsByName(role)) {
                        roleRepository.save(new Role(Roles.valueOf(role.name())));
                    }
                }
        );
    }
}
