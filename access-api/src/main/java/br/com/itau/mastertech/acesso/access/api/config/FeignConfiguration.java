package br.com.itau.mastertech.acesso.access.api.config;

import br.com.itau.mastertech.acesso.access.api.service.fallback.ClientServiceFallback;
import br.com.itau.mastertech.acesso.access.api.service.fallback.DoorServiceFallback;
import feign.Feign;
import feign.RetryableException;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Feign.Builder feignBuilder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(ClientServiceFallback::new, RetryableException.class)
                .withFallbackFactory(ClientServiceFallback::new, RuntimeException.class)
                .withFallbackFactory(DoorServiceFallback::new, RetryableException.class)
                .withFallbackFactory(DoorServiceFallback::new, RuntimeException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
