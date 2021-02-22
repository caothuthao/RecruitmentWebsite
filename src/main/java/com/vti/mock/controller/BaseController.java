package com.vti.mock.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.vti.mock.constants.UrlConstant;
import com.vti.mock.util.SecurityUtils;

@Controller
public class BaseController {

	@GetMapping(value = { "/", "/login" })
	public String login(@RequestParam(required = false) String message, final Model model) {
		if (SecurityUtils.isAuthenticated()) {
			return UrlConstant.getRedirectUrl(UrlConstant.Student.LIST);
		}
		if (StringUtils.isNotEmpty(message)) {
			String key = "message";
			if (message.equals("logout")) {
				model.addAttribute(key, "system.logout");
			}
			if (message.equals("error")) {
				model.addAttribute(key, "system.login.failed");
			}
			if (message.equals("timeout")) {
				model.addAttribute(key, "system.session.timeout");
			}
			if (message.equals("max_session")) {
				model.addAttribute(key, "system.login.another_device");
			}
		}
		return "common/login";
	}

	@GetMapping("/home")
	public String base() {
		return "index";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "login";
	}

	@GetMapping("/change_language")
	@ResponseBody
	public String changeLanguage() {
		return "OK";
	}

}
