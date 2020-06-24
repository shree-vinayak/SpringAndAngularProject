package com.sv.aartek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.sv.aartek.models.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>, RevisionRepository<UserInfo, Integer, Integer> {

	public UserInfo findByUsername(String username);
}
