package com.ashupan.authservice.feignInterface;

import com.ashupan.authservice.responseDTO.AppUserResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.ashupan.authservice.constants.MicroServiceConstants.*;

@FeignClient(name = APPUSER_MICROSERVICE)
@Service
@RequestMapping(value = BASE_API)
public interface AppUserInterface {

    @RequestMapping(value = AppUserMicroServiceConstants.FETCH_APPUSER_BY_USERNAME)
    Optional<AppUserResponseDTO> fetchAppUserByUsername(@PathVariable("username") String username);
}
