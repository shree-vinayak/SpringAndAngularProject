package com.sv.aartek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sv.aartek.config.AuditAwareImpl;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sv.aartek.common", "com.sv.aartek.config", "com.sv.aartek.controllers",
		"com.sv.aartek.serviceImpl" })
@EntityScan(basePackages = { "com.sv.aartek.models","com.sv.aartek.config" })
@EnableJpaRepositories(basePackages = {
		"com.sv.aartek.repo" }, repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class HrmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsBackendApplication.class, args);
	}
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditAwareImpl();
	}

}
