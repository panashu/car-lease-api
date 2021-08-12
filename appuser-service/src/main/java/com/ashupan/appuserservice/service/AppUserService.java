package com.ashupan.appuserservice.service;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;
import com.ashupan.appuserservice.dto.response.AppUserResponseDTO;
import com.ashupan.appuserservice.dto.response.ResponseDTO;
import com.ashupan.appuserservice.entities.AppUser;

import java.util.List;

/**
 * @author ashutosh
 */
public interface AppUserService {

    void saveAppUser(AppUserRequestDTO requestDTO);

    AppUserResponseDTO searchAppUser(AppUserRequestDTO requestDTO);

    AppUser fetchAppUserByUsername(String username);
    
}
