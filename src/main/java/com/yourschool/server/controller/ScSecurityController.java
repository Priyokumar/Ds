package com.yourschool.server.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.security.ChangePassword;
import com.yourschool.server.dto.security.Login;
import com.yourschool.server.dto.security.LoginOtpVerificationRequest;
import com.yourschool.server.dto.security.LoginResponse;
import com.yourschool.server.dto.user.RolesResponse;
import com.yourschool.server.service.ScSecurityService;

@RestController
@RequestMapping("")
public class ScSecurityController {

	@Autowired
	private ScSecurityService securityService;

	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponse> login(@RequestBody Login login, HttpServletResponse response)
			throws Exception {

		LoginResponse resp = securityService.login(login);

		return ResponseEntity.ok().body(resp);
	}

	@PostMapping(value = "/login/otp-verification")
	public ResponseEntity<ActionResponse> otpVerification(@RequestBody LoginOtpVerificationRequest request) {

		ActionResponse response = securityService.verify(request);
		HttpCookie cookie = ResponseCookie.from("token", response.getApiMessage().getDetail()).path("/").build();

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(response);
	}

	@GetMapping(value = "/{id}/logout")
	public ActionResponse logout(@PathVariable("id") Long id) {
		return securityService.logout(id);
	}

	@PostMapping(value = "/change-password")
	public ActionResponse changePassword(@RequestBody ChangePassword changePassword) {
		return securityService.changePassword(changePassword);
	}

	@GetMapping(value = "/{userId}/roles")
	public RolesResponse roles(@PathVariable("userId") Long userId) {
		return securityService.roles(userId);
	}
}
