import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import microteam.z.TestSettings;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT) // Enables parallel test execution
public class E2ETests {

    @Autowired
    private WebDriver driver;

    @Autowired
    private TestSettings testSettings;

    @Test
    public void testBaseURL() {
        driver.get(testSettings.getBaseURL());
        assertTrue(driver.getTitle().contains("Expected Title"));
    }

    @Test
    public void testLogin() {
        driver.get(testSettings.getBaseURL() + "/login");
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();

        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }
}
