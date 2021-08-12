package com.ashupan.appuserservice.service;
/*package com.ashupan.appuserservice.service;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;
import com.ashupan.appuserservice.exceptions.DataDuplicationException;
import com.ashupan.appuserservice.repository.AppUserRepository;
import com.ashupan.appuserservice.service.impl.AppUserServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.ashupan.appuserservice.utils.AppUserRequestUtils.*;
import static org.mockito.BDDMockito.given;

*//**
 * @author ashutosh on 8/11/21
 *//*

@RunWith(MockitoJUnitRunner.class)
public class AppUserServiceImplTest {

    @InjectMocks
    private AppUserServiceImpl appUserService;

    @Mock
    private AppUserRepository appUserRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Should_ThrowException_When_UsernameAlreadyExists() {
        AppUserRequestDTO appUserRequestDTO = getAppUserRequestDTO();

        given(appUserRepository.fetchAppUserByUsername(appUserRequestDTO.getUsername()))
                .willReturn(Optional.of(getAppUser()));

        thrown.expect(DataDuplicationException.class);

        appUserService.saveAppUser(appUserRequestDTO);
    }

    @Test
    public void Should_ThrowException_When_EmailAddressAlreadyExists() {
        AppUserRequestDTO appUserRequestDTO = getAppUserRequestDTO();

        given(appUserRepository.fetchAppUserByEmailAddress(appUserRequestDTO.getEmailAddress()))
                .willReturn(Optional.of(getAppUser()));

        thrown.expect(DataDuplicationException.class);

        appUserService.saveAppUser(appUserRequestDTO);
    }

    @Test
    public void Should_Successfully_SaveAppUser() {
        AppUserRequestDTO appUserRequestDTO = getAppUserRequestDTO();

        given(appUserRepository.fetchAppUserByUsername(appUserRequestDTO.getUsername()))
                .willReturn(Optional.empty());

        given(appUserRepository.fetchAppUserByEmailAddress(appUserRequestDTO.getEmailAddress()))
                .willReturn(Optional.empty());

        appUserService.saveAppUser(appUserRequestDTO);
    }
}
*/