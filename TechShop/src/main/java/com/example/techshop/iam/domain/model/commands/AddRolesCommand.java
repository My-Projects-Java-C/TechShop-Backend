package com.example.techshop.iam.domain.model.commands;

import com.example.techshop.iam.domain.model.aggregates.User;

public record AddRolesCommand(String roleName, String email) {
}
