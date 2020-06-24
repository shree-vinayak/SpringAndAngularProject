package com.sv.aartek.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.sv.aartek.config.AuditRevisionListener;

/**
 * @author Ankit Rajpoot
 */
@Entity
@Table
@RevisionEntity(AuditRevisionListener.class)
public class AuditRevisionEntity extends DefaultRevisionEntity {

	private static final long serialVersionUID = 1701957268141910103L;

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
