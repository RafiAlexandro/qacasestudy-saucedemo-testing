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

public class Login extends env_target {
    @Given("User is already on login page")
    public void userIsAlreadyOnLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(baseUrl)
        );
    }

    @When("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User get error username and password required")
    public void userGetErrorUsernameAndPasswordRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"),"Epic sadface: Username and password are required")
        );
        driver.quit();
    }

    @When("User input invalid username and correct password")
    public void userInputInvalidUsernameAndCorrectPassword() {
        driver.findElement(By.id("user-name")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User get error username and password do not match")
    public void userGetErrorUsernameAndPasswordDoNotMatch() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"),"Epic sadface: Username and password do not match any user in this service")
        );
        driver.quit();
    }

    @And("User input correct username and invalid password")
    public void userInputCorrectUsernameAndInvalidPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
    }

    @When("User input correct username")
    public void userInputCorrectUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @Then("User get error password is required")
    public void userGetErrorPasswordIsRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"),"Epic sadface: Password is required")
        );
        driver.quit();
    }

    @When("User input correct password")
    public void userInputCorrectPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User get error username is required")
    public void userGetErrorUsernameIsRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"),"Epic sadface: Username is required")
        );
        driver.quit();
    }

    @When("User input username and password")
    public void userInputUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User successfully login")
    public void userSuccessfullyLogin() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
        driver.quit();
    }


}
