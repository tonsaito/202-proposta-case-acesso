package br.com.itau.mastertech.acesso.access.api;

import br.com.itau.mastertech.acesso.access.api.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class AccessApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessApiApplication.class, args);
	}

}
