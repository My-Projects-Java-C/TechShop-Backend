package com.example.techshop.iam.domain.service;

import com.example.techshop.iam.domain.model.commands.GetDefaultRoleCommand;
import com.example.techshop.iam.domain.model.commands.SeedRolesCommand;
import com.example.techshop.iam.domain.model.entities.Role;

import java.util.Optional;

public interface RoleCommandService {

    void execute(SeedRolesCommand command);
}
