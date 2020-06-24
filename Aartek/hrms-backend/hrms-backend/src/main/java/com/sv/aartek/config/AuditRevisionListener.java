package com.sv.aartek.config;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.sv.aartek.models.AuditRevisionEntity;

/**
 * @author Ankit Rajpoot
 */
public class AuditRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		AuditRevisionEntity auditRevisionEntity = (AuditRevisionEntity) revisionEntity;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = null;
		try {
			name = ((UserDetails) authentication.getPrincipal()).getUsername();
		} catch (Exception e) {
			name = "ankitrajpootsv.ar@gmail.com";
		}
		auditRevisionEntity.setUsername(name);
	}

}
