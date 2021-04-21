package crawler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumConfig {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        final ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }

}