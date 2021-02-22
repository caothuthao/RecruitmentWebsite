package com.vti.mock.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException {
		if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
			response.sendRedirect(request.getContextPath() + "/login?message=max_session");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/login?message=error");
	}

}
