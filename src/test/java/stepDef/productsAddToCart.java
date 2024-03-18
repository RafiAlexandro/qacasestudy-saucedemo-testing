package stepDef;

import config.env_target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.List;

public class productsAddToCart extends env_target {
    @Given("User in the login page")
    public void userInTheLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(baseUrl)
        );
    }

    @When("User insert the username and password")
    public void userInsertTheUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User is click login button")
    public void userIsClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Website will direct to products page")
    public void websiteWillDirectToProductsPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
    }

    @And("User click add to cart button")
    public void userClickAddToCartButton() {
        List<WebElement> multipleclick = driver.findElements(By.className("btn_inventory"));

        for (WebElement addtocart : multipleclick) {
            addtocart.click();
        }
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("Product will appear in cart page")
    public void ProductWillAppearInCartPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/cart.html"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_4_title_link\"]/div"),"Sauce Labs Backpack"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_1_title_link\"]/div"),"Sauce Labs Bolt T-Shirt"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_5_title_link\"]/div"),"Sauce Labs Fleece Jacket"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_2_title_link\"]/div"),"Sauce Labs Onesie"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_3_title_link\"]/div"),"Test.allTheThings() T-Shirt (Red)"),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"item_0_title_link\"]/div"),"Sauce Labs Bike Light")
                )
        );
        driver.quit();
    }

    @Then("Website will display remove button")
    public void WebsiteWillDisplayRemoveButton() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.className("btn_inventory"),"REMOVE")
        );
    }

    @And("User click remove button")
    public void userClickRemoveButton() {
        List<WebElement> remove = driver.findElements(By.className("btn_inventory"));

        for (WebElement clickremove : remove) {
            clickremove.click();
        }
    }

    @And("User click remove button from cart page")
    public void userClickRemoveButtonFromCartPage() {
        List<WebElement> remove = driver.findElements(By.className("cart_button"));

        for (WebElement clickremove : remove) {
            clickremove.click();
        }
    }

    @Then("User successfully remove product")
    public void userSuccessfullyRemoveProduct() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.className("cart_item"))
        );
        driver.quit();
    }
}
