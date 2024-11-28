package microteam.z;
//import Configuration.microteam.z-root.playwright-config-ts.TestConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class TestSettings {
    private String baseURL;
    private int retries;
    private boolean fullyParallel;

    public TestSettings(String baseURL, int retries, boolean fullyParallel) {
        this.baseURL = baseURL;
        this.retries = retries;
        this.fullyParallel = fullyParallel;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public int getRetries() {
        return retries;
    }

    public boolean isFullyParallel() {
        return fullyParallel;
    }
}
