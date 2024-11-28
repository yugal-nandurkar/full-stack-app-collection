package microteam.root.HybridApp.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class RazorRoutesViewResolverConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/microteam/root/HybridApp/Component.Layouts/");
        resolver.setSuffix(".html");
        return resolver;
    }
}
