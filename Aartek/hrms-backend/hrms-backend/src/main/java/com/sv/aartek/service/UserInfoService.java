package com.sv.aartek.service;

import com.sv.aartek.models.UserInfo;
import com.sv.aartek.result.ResultWrapper;

public interface UserInfoService {

	public ResultWrapper<UserInfo> findOne(String username, String token);

	public ResultWrapper<UserInfo> save(UserInfo userInfo);


}
