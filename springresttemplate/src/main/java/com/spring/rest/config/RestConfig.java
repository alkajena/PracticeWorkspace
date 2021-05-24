package com.spring.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.XmlAwareFormHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	@SuppressWarnings("deprecation")
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate template=new RestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter());
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		template.getMessageConverters().add(new XmlAwareFormHttpMessageConverter());
		return template;	
	}

}
