package com.ashupan.loginservice.service.serviceImpl;

import com.ashupan.loginservice.constants.ErrorMessageConstants.ForgetPassword;
import com.ashupan.loginservice.constants.ErrorMessageConstants.InvalidAppUserUsername;
import com.ashupan.loginservice.constants.PatternConstants.EmailConstants;
import com.ashupan.loginservice.exceptions.UnauthorisedException;
import com.ashupan.loginservice.feignInterface.AppUserInterface;
import com.ashupan.loginservice.jwt.JwtTokenProvider;
import com.ashupan.loginservice.requestDTO.AppUserRequestDTO;
import com.ashupan.loginservice.requestDTO.LoginRequestDTO;
import com.ashupan.loginservice.responseDTO.AppUserResponseDTO;
import com.ashupan.loginservice.service.LoginService;
import com.ashupan.loginservice.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional("transactionManager")
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AppUserInterface appUserInterface;

    @Override
    public String login(LoginRequestDTO requestDTO, HttpServletRequest request) {

        long startTime = DateUtils.getTimeInMillisecondsFromLocalDate();

        AppUserResponseDTO appUser = fetchAppUserDetails.apply(requestDTO);

        validateAppUserUsername.accept(appUser);

        validatePassword.accept(requestDTO, appUser);

        String jwtToken = jwtTokenProvider.createToken(requestDTO.getUserCredential(), request);

        LOGGER.info("LOGIN PROCESS COMPLETED IN ::: " + (DateUtils.getTimeInMillisecondsFromLocalDate() - startTime)
                + " ms");

        return jwtToken;
    }

    private Function<LoginRequestDTO, AppUserResponseDTO> fetchAppUserDetails = (loginRequestDTO) -> {

        Pattern pattern = Pattern.compile(EmailConstants.EMAIL_PATTERN);
        Matcher m = pattern.matcher(loginRequestDTO.getUserCredential());
        LOGGER.info("fetchAppUserDetails");
        return m.find() ? appUserInterface.searchAppUser
                (AppUserRequestDTO.builder().username(null).emailAddress(loginRequestDTO.getUserCredential()).build())
                : appUserInterface.searchAppUser
                (AppUserRequestDTO.builder().username(loginRequestDTO.getUserCredential()).emailAddress(null).build());
    };

    private Consumer<AppUserResponseDTO> validateAppUserUsername = (appUser) -> {
        if (Objects.isNull(appUser))
            throw new UnauthorisedException(InvalidAppUserUsername.MESSAGE, InvalidAppUserUsername.DEVELOPER_MESSAGE);
        LOGGER.info(":::: APPUSER USERNAME VALIDATED ::::");
    };

    private BiConsumer<LoginRequestDTO, AppUserResponseDTO> validatePassword = (requestDTO, appUser) -> {

        LOGGER.info(":::: APPUSER PASSWORD VALIDATION ::::");

        if (!BCrypt.checkpw(requestDTO.getPassword(), appUser.getPassword())) {
        	LOGGER.debug("INCORRECT PASSWORD...");
            throw new UnauthorisedException(ForgetPassword.MESSAGE, ForgetPassword.DEVELOPER_MESSAGE);
        } 
        
        LOGGER.info(":::: APPUSER PASSWORD VALIDATED ::::");
    };

}

