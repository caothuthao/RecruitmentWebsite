package com.vti.mock.util.validation;

import org.apache.commons.lang3.StringUtils;

import com.vti.mock.constants.CommonConstant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isEmpty(email)) {
			return true;
		}
		return (validateEmail(email));
	}

	private boolean validateEmail(final String email) {
		Pattern pattern = Pattern.compile(CommonConstant.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public void initialize(ValidEmail constraintAnnotation) {

	}

}
