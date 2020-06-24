package com.sv.aartek.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sv.aartek.models.UserInfo;
import com.sv.aartek.repo.UserInfoRepo;
import com.sv.aartek.result.Result;
import com.sv.aartek.result.ResultWrapper;
import com.sv.aartek.service.UserInfoService;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserDetailsService, UserInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	// To get User object from the database and form ResultWrapper Object with
	// token
	@Override
	public ResultWrapper<UserInfo> findOne(String username, String token) {
		ResultWrapper<UserInfo> result = new ResultWrapper<>();
		try {
			UserInfo user = userInfoRepo.findByUsername(username);
			result.setResult(user);
			result.setToken(token);
			result.setStatus(Result.SUCCESS);
			result.setMessage("Logged In Successfully");
		} catch (Exception e) {
			result.setStatus(Result.EXCEPTION);
			result.setMessage("Invalid User");
		}
		return result;
	}

	// To save the user in db
	@Override
	public ResultWrapper<UserInfo> save(UserInfo userInfo) {
		ResultWrapper<UserInfo> result = new ResultWrapper<>();
		try {
			String pass = userInfo.getPassword();
			userInfo.setPassword(bcryptEncoder.encode(userInfo.getPassword()));
			userInfo = userInfoRepo.save(userInfo);
			result.succeedCreated(userInfo, userInfo.getFullName());

		} catch (Exception e) {
			result.setStatus(Result.EXCEPTION);
			result.setMessage(e.toString());
			result.setResult(null);
			LOGGER.error(e.toString());
		}
		return result;
	}

	// To get the user from db on the basis of specific username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userInfoRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(UserInfo user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return authorities;
	}

}
