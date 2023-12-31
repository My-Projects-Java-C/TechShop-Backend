package com.example.techshop.shared.application.eventhandlers;


import com.example.techshop.iam.domain.model.commands.SeedRolesCommand;
import com.example.techshop.iam.domain.service.RoleCommandService;
import com.example.techshop.productmanagement.domain.model.commands.SeedCategoryCommand;
import com.example.techshop.productmanagement.domain.model.commands.SeedComputerComponentCommand;
import com.example.techshop.productmanagement.domain.services.ProductCommandService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@AllArgsConstructor
@Service
public class ApplicationReadyEventHandler {

    private final RoleCommandService roleCommandService;

    private final ProductCommandService productCommandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    @EventListener
    public void seedRoles (ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is nedded for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
        var seedRolesCommand = new SeedRolesCommand();
        roleCommandService.execute(seedRolesCommand);
        LOGGER.info("Roles seeding verification finished for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
    }

    @EventListener
    public void seedCategories(ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if categories seeding is nedded for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
        var seedCategoryCommand = new SeedCategoryCommand();
        productCommandService.execute(seedCategoryCommand);
        LOGGER.info("Categories seeding verification finished for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
    }

    @EventListener
    public void SeedComputerComponents (ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if computer components seeding is nedded for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
        var seedComputerComponentCommand = new SeedComputerComponentCommand();
        productCommandService.execute(seedComputerComponentCommand);
        LOGGER.info("Computer components seeding verification finished for {} at {}", applicationName, new Timestamp(System.currentTimeMillis()));
    }



}
