package com.ashupan.appuserservice.query;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ashutosh on 8/11/21
 */
public class AppUserQuery {
    public static Supplier<String> createQueryToFetchAppUsersToSendEmail = () ->
            " SELECT a.id, a.email_address FROM app_user a WHERE a.email_sent = 'N'";

    public static Function<AppUserRequestDTO, String> createQueryToFetchAppUserDetails = (requestDTO) -> {

        String query = "";

        query = " SELECT a.id," +                            //[0]
                " a.password," +                            //[1]
                " a.email_address" +                        //[4]
                " FROM" +
                " app_user a" +
                " WHERE" +
                " a.id!=0";

        if (!Objects.isNull(requestDTO.getUsername()))
            query += " AND a.username= '" + requestDTO.getUsername() + "'";

        if (!Objects.isNull(requestDTO.getEmailAddress()))
            query += " AND a.email_address= '" + requestDTO.getEmailAddress() + "'";

        return query;
    };

    public static Function<String, String> getAppUserCountByUsername = (username) ->
            "SELECT COUNT(a.id) FROM app_user a WHERE a.username = '" + username + "'";

    public static Function<String, String> getAppUserCountByEmailAddress = (emailAddress) ->
            "SELECT COUNT(a.id) FROM app_user a WHERE a.email_address = '" + emailAddress + "'";
}
