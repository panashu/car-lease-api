package com.ashupan.appuserservice.utility;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author ashutosh on 8/11/21
 */
public class DateUtils {
    public static long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }
}
