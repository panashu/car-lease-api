package com.ashupan.authservice.constants;

public class MicroServiceConstants {

    public static final String LOGIN_MICROSERVICE = "/login-service/api/login";

    public static final String APPUSER_MICROSERVICE = "appuser-service";
    public static final String BASE_API = "/api";

    public interface AppUserMicroServiceConstants {
        String FETCH_APPUSER_BY_USERNAME = "/fetch-appuser/{username}";
    }
}
