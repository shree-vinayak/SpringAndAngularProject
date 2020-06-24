package com.sv.aartek.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Ankit Rajpoot
 */

public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		String name = null;
		try {
			name = ((UserDetails) authentication.getPrincipal()).getUsername();
		} catch (Exception e) {
			name = "ankitrajpootsv.ar@gmail.com";
		}
		Optional<String> opt = Optional.of(name);

		// return ((UserDetails) authentication.getPrincipal()).getUser();
		return opt;

	}
}
