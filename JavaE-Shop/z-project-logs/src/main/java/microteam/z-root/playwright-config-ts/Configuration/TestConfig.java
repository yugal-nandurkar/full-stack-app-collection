import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
//import org.junit.jupiter.api.parallel.Execution;
//import org.junit.jupiter.api.parallel.ExecutionMode;
import TestSettings;

@Configuration
public class TestConfig {

    @Value("${base.url:http://localhost:5045}")
    private String baseURL;

    @Value("${CI:false}")
    private boolean isCI;

    @Value("${STORAGE_STATE}")
    private String storageState;

    @Bean
    public WebDriver webDriver() {
        // Set ChromeDriver location (ensure it's in your PATH or specify the path)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // for CI environments (optional)
        options.addArguments("--disable-gpu");

        return new ChromeDriver(options);
    }

    @Bean
    public TestSettings testSettings() {
        // Configurable settings based on environment variables or default values
        int retries = isCI ? 2 : 0;
        boolean fullyParallel = !isCI;

        return new TestSettings(baseURL, retries, fullyParallel);
    }
}

