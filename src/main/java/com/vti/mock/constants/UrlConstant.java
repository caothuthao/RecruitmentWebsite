package com.vti.mock.constants;

public class UrlConstant {

    private UrlConstant() {
    }

    public static final String REFRESH_TOKEN = "/get_refresh_token";

    public class Student {
        private Student() {
        }

        public static final String LIST = "/student/list";
        public static final String SEARCH = "/student/search";
        public static final String ADD = "/student/add";
        public static final String EDIT = "/student/edit";
        public static final String DELETE = "/student/delete/{id}";
    }

    public static String getRedirectUrl(String url) {
        return "redirect:" + url;
    }

}
