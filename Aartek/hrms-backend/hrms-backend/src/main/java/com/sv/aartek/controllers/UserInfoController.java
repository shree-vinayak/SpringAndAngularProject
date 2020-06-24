package com.sv.aartek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.aartek.models.UserInfo;
import com.sv.aartek.result.ResultWrapper;
import com.sv.aartek.service.UserInfoService;

@RestController
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	// This api is used for save the Employee
	@PreAuthorize("hasAnyRole('HR','MANAGER','MD')")
	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveUser(@RequestBody UserInfo userInfo) {
		ResultWrapper<UserInfo> result = userInfoService.save(userInfo);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}
