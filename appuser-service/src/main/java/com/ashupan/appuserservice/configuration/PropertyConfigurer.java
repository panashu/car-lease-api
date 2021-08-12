package com.ashupan.appuserservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfigurer {

	@Bean
	@ConfigurationProperties("appuser.broker")
	public StartupProperties startupPropertiesBroker(){
		return new StartupProperties();
	}
	
	@Bean
	@ConfigurationProperties("appuser.employee")
	public StartupProperties startupPropertiesEmployee(){
		return new StartupProperties();
	}
}
