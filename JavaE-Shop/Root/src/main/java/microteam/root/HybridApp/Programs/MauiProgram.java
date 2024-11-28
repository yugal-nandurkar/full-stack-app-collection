package microteam.root.HybridApp.Programs;

//package com.eshop.hybridapp;

import microteam.root.HybridApp.Services.CatalogService;
import microteam.root.HybridApp.Services.ProductImageUrlProvider;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MauiProgram {

    // NOTE: Must have a trailing slash on base URLs to ensure the full BaseAddress URL is used to resolve relative URLs
    private static final String MOBILE_BFF_HOST = "http://localhost:11632/";

    public static void main(String[] args) {
        SpringApplication.run(MauiProgram.class, args);
    }

    @Bean
    public RestTemplate catalogServiceRestTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri(MOBILE_BFF_HOST)
                .build();
    }

    @Bean
    public CatalogService catalogService(RestTemplate restTemplate) {
        return new CatalogService(restTemplate);
    }

    @Bean
    public ProductImageUrlProvider productImageUrlProvider() {
        return new ProductImageUrlProvider();
    }

    @Bean
    public org.slf4j.Logger logger() {
        return LoggerFactory.getLogger(MauiProgram.class);
    }
}

