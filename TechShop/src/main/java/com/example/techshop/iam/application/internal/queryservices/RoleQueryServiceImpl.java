package com.example.techshop.iam.application.internal.queryservices;

import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.domain.model.queries.GetAllRolesQuery;
import com.example.techshop.iam.domain.model.queries.GetRoleByNameQuery;
import com.example.techshop.iam.domain.service.RoleQueryService;
import com.example.techshop.iam.infraestructure.persistence.jpa.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleQueryServiceImpl implements RoleQueryService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> execute(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> execute(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
