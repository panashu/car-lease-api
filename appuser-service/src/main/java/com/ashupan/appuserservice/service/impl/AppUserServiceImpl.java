package com.ashupan.appuserservice.service.impl;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;
import com.ashupan.appuserservice.dto.response.AppUserResponseDTO;
import com.ashupan.appuserservice.entities.AppUser;
import com.ashupan.appuserservice.exceptions.NoContentFoundException;
import com.ashupan.appuserservice.repository.AppUserRepository;
import com.ashupan.appuserservice.service.AppUserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.function.Consumer;

import static com.ashupan.appuserservice.query.AppUserQuery.createQueryToFetchAppUserDetails;
import static com.ashupan.appuserservice.utility.AppUserUtils.convertToAppUserResponse;

/**
 * @author ashutosh
 */

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public void saveAppUser(AppUserRequestDTO requestDTO) {

        log.info(":::: SAVE APPUSER PROCESS STARTED::::");
        validateAppUserRequestDTO.accept(requestDTO);

        System.out.println("VALIDATION DONE");
    }

    public Consumer<AppUserRequestDTO> validateAppUserRequestDTO = (requestDTO) -> {
        
    };


    /*SEARCH APPUSER FOR LOGIN VALIDATION*/
    @Override
    public AppUserResponseDTO searchAppUser(AppUserRequestDTO requestDTO) throws NoContentFoundException {

        List<Object[]> results = entityManager.createNativeQuery(
                createQueryToFetchAppUserDetails.apply(requestDTO)).getResultList();

        return convertToAppUserResponse.apply(results);
    }
    
    @Override
    public AppUser fetchAppUserByUsername(String username) {
        return null;
    }  
    
}
