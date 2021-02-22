package com.vti.mock.constants;

public class CommonConstant {

    private CommonConstant() {
    }

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[_A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static class ErrorMessage {
        private ErrorMessage() {
        }

        public static final String FORMAT = "message.error.file.format";
        public static final String DUPLICATE = "message.error.duplicate";
        public static final String MAXLENGTH = "message.error.length.max.255";
        public static final String REQUIRED = "message.error.required";
        public static final String DEL_STATUS = "message.error.account.del_status";
        public static final String ID = "message.error.identity.input";
    }

    public static class UserMessage {
        private UserMessage() {
        }

        public static final String PASS_NOT_MATCH = "message.error.password.non.match";
        public static final String ACCOUNT_EXIST = "message.error.account.exist";
        public static final String REGISTER_SUCCESS = "message.success.add";
        public static final String EDIT_SUCCESS = "message.success.edit";
        public static final String RESET_SUCCESS = "message.success.password.reset";
        public static final String CURRENT_PASS = "message.error.password.current";
    }

}
