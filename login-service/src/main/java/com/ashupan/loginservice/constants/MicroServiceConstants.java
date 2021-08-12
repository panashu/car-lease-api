package com.ashupan.loginservice.constants;

/**
 * This class includes the name and API end points of other microservices that we need to communicate.
 * NOTE: WRITE EVERYTHING IN ALPHABETICAL ORDER
 */
public class MicroServiceConstants {

    public static final String BASE_API = "/api";

    public interface AppUserMicroServiceConstants {
        String BASE = "appuser-service";
        String SEARCH_APPUSER = "/search";
        String UPDATE_APPUSER = "/update";
    }
}
