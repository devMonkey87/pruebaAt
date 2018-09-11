package com.example.demoJPA.camelConfig;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:/demoJPA/originFolder").to("file:/demoJPA/targetFolder");
	}
}