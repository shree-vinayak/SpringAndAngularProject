package com.sv.aartek.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.sv.aartek.common.AuditEnabledEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@Audited
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfo extends AuditEnabledEntity implements Serializable {

	private static final long serialVersionUID = -7504512749685643994L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "contact", nullable = false)
	private Long contact;

	@Column(name = "confirmPassword", nullable = false)
	private String confirmPassword;

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Column(name = "role", nullable = false)
	private String role;

	private Boolean smsFlag;

	private Boolean emailFlag;

}
