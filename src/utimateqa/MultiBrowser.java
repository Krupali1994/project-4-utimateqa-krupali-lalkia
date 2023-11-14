package utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    // 1. Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("You have entered invalid browser");
        }

        // 2. Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize(); // Maximise the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); ////Implicit wait timing to driver

        // 3. Print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // 4. Print the current url
        System.out.println("The current URL: " + driver.getCurrentUrl());

        // 5. Print the page source
        System.out.println(driver.getPageSource());

        // 6. Click on ‘Sign In’ link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();

        // 7. Print the current url
        System.out.println(" The current URL: " + driver.getCurrentUrl());

        // 8. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Prime@gmail.com");

        // 9. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("p12345");

        // 10. Click on Login Button
        WebElement loginButton = driver.findElement(By.partialLinkText("Sign"));
        loginButton.click();

        // 11. Navigate to baseUrl
        driver.navigate().to(baseUrl);

        // 12. Navigate forward to Homepage
        driver.navigate().forward();

        // 13. Navigate back to baseUrl
        driver.navigate().to(baseUrl);

        // 14. Refresh the page
        driver.navigate().refresh();

        // 15. Close the browser
        driver.quit();

    }
}
