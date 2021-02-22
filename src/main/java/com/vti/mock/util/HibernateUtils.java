package com.vti.mock.util;

import org.springframework.util.StringUtils;

public final class HibernateUtils {

    private HibernateUtils() {
    }

    public static String escapeSQLLikeStatement(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return value
                .replaceAll("%", "\\\\%")
                .replaceAll("_", "\\\\_");
    }

}
