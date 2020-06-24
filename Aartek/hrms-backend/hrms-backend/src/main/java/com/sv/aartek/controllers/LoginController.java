package com.sv.aartek.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sv.aartek.config.JwtTokenUtil;
import com.sv.aartek.models.UserInfo;
import com.sv.aartek.result.ResultWrapper;
import com.sv.aartek.service.UserInfoService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserInfoService userInfoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ResultWrapper<UserInfo>> register(@RequestBody UserInfo loginUser)
			throws AuthenticationException {

		Authentication authentication = null;
		authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		ResultWrapper<UserInfo> result = null;
		if (token != null) {
			String username = authentication.getName();
			result = userInfoService.findOne(username, token);
		}
		return new ResponseEntity<ResultWrapper<UserInfo>>(result, HttpStatus.OK);

	}

	// To validata the token and return true if the token is validate
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ResponseEntity<Boolean> validate() throws AuthenticationException {
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("value", "true");
//		return ResponseEntity.ok().headers(responseHeaders).body("");
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}