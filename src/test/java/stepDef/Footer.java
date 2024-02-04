package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Footer extends env_target {
    @Given("User is on a login page")
    public void userIsOnALoginPage() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(baseUrl)
        );
    }

    @When("User fill a username and password")
    public void userFillAUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click the login")
    public void userClickTheLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Website direct to products page and contains footer and social media icons")
    public void websiteDirectToProductsPageAndContainsFooterAndSocialMediaIcons() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.and(
                    ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html"),
                    ExpectedConditions.visibilityOfElementLocated(By.className("footer")),
                    ExpectedConditions.visibilityOfElementLocated(By.className("social_twitter")),
                    ExpectedConditions.visibilityOfElementLocated(By.className("social_facebook")),
                    ExpectedConditions.visibilityOfElementLocated(By.className("social_linkedin"))
                )
        );
    }

    @And("User click twitter icon")
    public void userClickTwitterIcon() {
        driver.findElement(By.className("social_twitter")).click();
    }

    @Then("Website will direct to twitter page")
    public void websiteWillDirectToTwitterPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.twitter.com")
        );
    }

    @And("User click facebook icon")
    public void userClickFacebookIcon() {
        driver.findElement(By.className("social_facebook")).click();
    }

    @Then("Website will direct to facebook page")
    public void websiteWillDirectToFacebookPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.facebook.com")
        );
    }

    @And("User click linkedin icon")
    public void userClickLinkedinIcon() {
        driver.findElement(By.className("social_linkedin")).click();
    }

    @Then("Website will direct to linkedin page")
    public void websiteWillDirectToLinkedinPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.linkedin.com")
        );
    }




}
