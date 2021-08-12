package com.ashupan.appuserservice.utility;

import com.ashupan.appuserservice.dto.request.AppUserRequestDTO;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class QueryCreator {

    public static Supplier<String> createQueryToFetchAppUsersToSendEmail = () ->
            " SELECT a.id, a.email_address FROM app_user a WHERE a.email_sent = 'N'";

    public static Function<AppUserRequestDTO, String> createQueryToFetchAppUserDetails = (requestDTO) -> {

        String query = "";

        query = " SELECT a.id," +                            //[0]
                " a.password," +                            //[1]
                " a.status," +                             //[2]
                " a.login_attempt," +                       //[3]
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
}
