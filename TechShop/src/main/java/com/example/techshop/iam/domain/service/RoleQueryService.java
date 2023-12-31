package com.example.techshop.iam.domain.service;


import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.domain.model.queries.GetAllRolesQuery;
import com.example.techshop.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {

    List<Role> execute(GetAllRolesQuery query);

    Optional<Role> execute(GetRoleByNameQuery query);
}
