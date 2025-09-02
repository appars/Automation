package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

    @Test
    public void getData() {
        System.out.println("Hello Guys");

        // Auto-download and configure the correct ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Options: headless mode is safer on build agents
        ChromeOptions options = new ChromeOptions();
        // Uncomment the line below if running in CI/CD:
        // options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://apparacademy-e4bybmd8cudcaqet.canadacentral-01.azurewebsites.net/webapp/");
            String text = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println("Page header: " + text);

            Assert.assertTrue(
                "Header text does not match!",
                text.equalsIgnoreCase("ApparAcademy.com International Academy")
            );
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
