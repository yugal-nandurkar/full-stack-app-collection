package microteam.root.HybridApp.Configuration;

import microteam.root.HybridApp.Services.CatalogService;
import microteam.root.HybridApp.Services.ProductImageUrlProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CatalogService catalogService(RestTemplate restTemplate) {
        return new CatalogService(restTemplate);
    }

    @Bean
    public ProductImageUrlProvider productImageUrlProvider() {
        return new ProductImageUrlProvider();
    }
}
