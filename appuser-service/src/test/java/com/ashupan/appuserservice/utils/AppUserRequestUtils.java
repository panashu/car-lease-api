package com.ashupan.appuserservice.utils;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;
import com.ashupan.appuserservice.entities.AppUser;

/**
 * @author ashutosh on 8/11/21
 */
public class AppUserRequestUtils {

    public static AppUserRequestDTO getAppUserRequestDTO() {
        return AppUserRequestDTO.builder()
                .username("ashupan")
                .fullName("Ashutosh Pandey")
                .emailAddress("ashu.pan@gmail.com")
                .build();
    }

    public static AppUser getAppUser() {
        AppUser appUser = new AppUser();
        appUser.setUsername("ashupan");
        appUser.setEmailAddress("ashu.pan@gmail.com");
        appUser.setFullName("Ashutosh Pandey");

        return appUser;
    }
}
