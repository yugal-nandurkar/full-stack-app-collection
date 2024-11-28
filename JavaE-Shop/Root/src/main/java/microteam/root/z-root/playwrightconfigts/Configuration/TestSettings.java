//import Configuration.microteam.z-root.playwrightconfigts.TestConfig;


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
