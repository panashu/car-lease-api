package com.ashupan.appuserservice.utility;

import com.ashupan.appuserservice.dto.response.AppUserResponseDTO;

import java.util.List;
import java.util.function.Function;

public class AppUserUtils {

    public static Function<Object[], AppUserResponseDTO> convertToResponse = (object) -> {
        final Integer APPUSER_ID = 0;
        final Integer EMAIL_ADDRESS_INDEX = 1;

        return AppUserResponseDTO.builder()
                .id(Long.parseLong(object[APPUSER_ID].toString()))
                .emailAddress(object[EMAIL_ADDRESS_INDEX].toString())
                .build();
    };

    public static Function<List<Object[]>, AppUserResponseDTO> convertToAppUserResponse = (objects) -> {
        final Integer ID = 0;
        final Integer PASSWORD = 1;
        final Integer EMAIL_ADDRESS = 2;

        AppUserResponseDTO responseDTO = new AppUserResponseDTO();

        objects.forEach(object -> {
            responseDTO.setId(Long.parseLong(object[ID].toString()));
            responseDTO.setPassword(object[PASSWORD].toString());
            responseDTO.setEmailAddress(object[EMAIL_ADDRESS].toString());
        });

        return responseDTO;
    };


}