package crawler;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


// T1: Login with invalid credentials and check error message
// T2: Login with empty username and check error message
// T3: Login successfully and check if you are navigated to the homepage

public class SeleniumTest {


    private static WebDriver driver;
    // Enter username and password from GitHub
    private String username = "";
    private String password = "";

    @BeforeTest
    public void setup() {
        driver = SeleniumConfig.getDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void T1() throws InterruptedException {
        // T1: Login with invalid credentials and check error message
        this.test("user", "user", "Incorrect username or password.");
    }


    @Test
    public void T2() throws InterruptedException {
        // T2: Login with empty username and check error message
        this.test("", "user", "Incorrect username or password.");
    }

    @Test
    public void T3() throws InterruptedException {
        // T3: Login successfully and check if you are navigated to the homepage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);
        assertTrue(new GitHubPage(driver).isLoaded());


    }

    private void test(String username, String password, String error) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, error);
    }

}
