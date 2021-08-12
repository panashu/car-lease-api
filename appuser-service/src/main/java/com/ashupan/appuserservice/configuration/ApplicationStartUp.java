package com.ashupan.appuserservice.configuration;

import com.ashupan.appuserservice.entities.AppUser;
import com.ashupan.appuserservice.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author
 * THIS CLASS RUNS BEFORE THE MAIN APPLICATION AND IS USED TO CREATE A SUPERAPPUSER DURING FIRST BOOT OF THE APPLICATION
 */
@Component
public class ApplicationStartUp {

	@Autowired
    private StartupProperties startupPropertiesBroker;
	
	@Autowired
    private StartupProperties startupPropertiesEmployee;

    @Bean
    public CommandLineRunner loadData(AppUserRepository appUserRepository) {
        return (args) -> {
            List<AppUser> appUsers = appUserRepository.findAll();

            if (ObjectUtils.isEmpty(appUsers))
                appUserRepository.save(saveAppUserBroker());
            	appUserRepository.save(saveAppUserEmployee());
            	
        };
    }

    public AppUser saveAppUserBroker() {
        AppUser appUser = new AppUser();
        appUser.setUsername(startupPropertiesBroker.getUsername());
        appUser.setFullName(startupPropertiesBroker.getFullName());
        appUser.setPassword(BCrypt.hashpw(startupPropertiesBroker.getPassword(), BCrypt.gensalt()));
        appUser.setEmailAddress(startupPropertiesBroker.getEmailAddress());
        appUser.setRoles(Arrays.asList("BROKER"));

        return appUser;
    }
    
    public AppUser saveAppUserEmployee() {
        AppUser appUser = new AppUser();
        appUser.setUsername(startupPropertiesEmployee.getUsername());
        appUser.setFullName(startupPropertiesEmployee.getFullName());
        appUser.setPassword(BCrypt.hashpw(startupPropertiesEmployee.getPassword(), BCrypt.gensalt()));
        appUser.setEmailAddress(startupPropertiesEmployee.getEmailAddress());
        appUser.setRoles(Arrays.asList("EMPLOYEE"));

        return appUser;
    }
}


