package com.ashupan.loginservice.feignInterface;

import com.ashupan.loginservice.constants.MicroServiceConstants;
import com.ashupan.loginservice.constants.MicroServiceConstants.*;
import com.ashupan.loginservice.requestDTO.AppUserRequestDTO;
import com.ashupan.loginservice.responseDTO.AppUserResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = AppUserMicroServiceConstants.BASE)
@Service
@RequestMapping(value = MicroServiceConstants.BASE_API)
public interface AppUserInterface {

    @RequestMapping(value = AppUserMicroServiceConstants.SEARCH_APPUSER)
    AppUserResponseDTO searchAppUser(@RequestBody AppUserRequestDTO requestDTO);
    
}
