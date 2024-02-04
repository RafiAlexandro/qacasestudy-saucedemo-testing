package stepDef;

import config.env_target;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class productsNavigation extends env_target {
    @Given("User is on login page")
    public void userIsOnLoginPage() {
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

    @When("User fill username and password")
    public void userFillUsernameAndPassword () {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User click login")
    public void userClickLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Website will be direct to products page")
    public void userWillBeDirectToProductsPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
    }

    @And("User click menu button")
    public void userClickMenuButton() {
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
    }

    @Then("Navigation menu will display links")
    public void navigationMenuWillDisplayLinks() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div/button")),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"inventory_sidebar_link\"]"),"All Items"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"about_sidebar_link\"]"),"About"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"logout_sidebar_link\"]"),"Logout"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"reset_sidebar_link\"]"),"Reset App State")
                )
        );
        driver.quit();
    }

    @Then("Navigation menu will appear links and close button")
    public void navigationMenuWillAppearLinkItemsAndCloseButton() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div/button")),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"inventory_sidebar_link\"]"),"All Items"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"about_sidebar_link\"]"),"About"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"logout_sidebar_link\"]"),"Logout"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"reset_sidebar_link\"]"),"Reset App State")
                )
        );
    }

    @And("User click all items link")
    public void userClickAllItemsLink() {
        driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]")).click();
    }

    @Then("Website will be direct to all product page")
    public void websiteWillBeDirectToAllItemsPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/allproduct.html")
        );
        driver.quit();
    }

    @And("user click about link")
    public void userClickAboutLink() {
        driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")).click();
    }

    @Then("Website will be direct to about page")
    public void websiteWillBeDirectToAboutPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://saucelabs.com/")
        );
        driver.quit();
    }

    @And("User click logout link")
    public void userClickLogoutLink() {
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    }

    @Then("Appear validation logout")
    public void appearValidationLogout() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("logout-validation"))
        );
    }

    @And("User click logout validation button")
    public void userClickLogoutValidationButton() {
        driver.findElement(By.className("fix-logout")).click();
    }

    @Then("User successfully logout")
    public void userSuccessfullyLogout() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/")
        );
        driver.quit();

    }

    @And("User click cancel validation button")
    public void userClickCancelValidationButton() {
        driver.findElement(By.className("fix-cancel")).click();
    }

    @Then("User successfully postpone logout")
    public void userSuccessfullyPostponeLogout() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
        driver.quit();
    }

    @And("User click reset app state link")
    public void userClickResetAppStateLink() {
        driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();
    }

    @Then("Website will reset app state")
    public void websiteWillResetAppState() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/reset.html")
        );
        driver.quit();
    }

    @And("User click close button")
    public void userClickCloseButton() {
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div/button")).click();
    }

    @Then("Navigation menu will be closed")
    public void navigationMenuWillBeClosed() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div"))
        );
        driver.quit();
    }

}
