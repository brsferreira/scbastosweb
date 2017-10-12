package com.scbastos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.scbastos.service.CadastroEnderecoService;
import com.scbastos.storage.FotoStorage;
import com.scbastos.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroEnderecoService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}
