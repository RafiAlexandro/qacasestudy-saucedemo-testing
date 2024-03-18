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

public class productsCart extends env_target {
    @Given("User on the login page")
    public void userOnTheLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(baseUrl)
        );
    }

    @When("User input the username and password")
    public void userInputTheUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click a login button")
    public void userClickALoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Website will direct to a products page")
    public void websiteWillDirectToAProductsPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
    }

    @And("User click the cart icon")
    public void userClickTheCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("Website will display cart page")
    public void websiteWillDisplayCartPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/cart.html")
        );
    }

    @And("User click continue shopping")
    public void userClickContinueShopping() {
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]")).click();
    }

    @Then("Website will return to product page")
    public void websiteWillReturnToProductPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
        driver.quit();
    }

    @And("User click checkout")
    public void userClickCheckout() {
        driver.findElement(By.className("checkout_button")).click();
    }

    @Then("Website cant direct to checkout one page")
    public void websiteCantDirectToCheckoutOnePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/cart.html")
        );
        driver.quit();
    }

    @And("User click the add to cart button")
    public void userClickTheAddToCartButton() {
        List<WebElement> multipleclick = driver.findElements(By.className("btn_inventory"));

        for (WebElement addtocart : multipleclick) {
            addtocart.click();
        }
    }

    @Then("Website will display cart page and display product")
    public void websiteWillDisplayCartPageAndDisplayProduct() {
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
    }

    @Then("Website will be direct to checkout one page")
    public void websiteWillBeDirectToCheckoutOnePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-one.html"),
                        ExpectedConditions.textToBe(By.className("subheader"),"Checkout: Your Information")
                )
        );
        driver.quit();
    }
}
