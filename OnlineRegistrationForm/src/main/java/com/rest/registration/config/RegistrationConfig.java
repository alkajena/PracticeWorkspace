package com.rest.registration.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.XmlAwareFormHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings({ "rawtypes" })
@Configuration
public class RegistrationConfig {

	@SuppressWarnings("deprecation")
	public RestTemplate getRestTemplate(){
		List<HttpMessageConverter<?>> messageConvertersList=new ArrayList<>();
		messageConvertersList.add(new StringHttpMessageConverter());
		messageConvertersList.add(new MappingJackson2HttpMessageConverter());
		messageConvertersList.add(new Jaxb2RootElementHttpMessageConverter());
		messageConvertersList.add(new XmlAwareFormHttpMessageConverter());
		RestTemplate template=new RestTemplate();
		template.setMessageConverters(messageConvertersList);
		return template;
	}
}
