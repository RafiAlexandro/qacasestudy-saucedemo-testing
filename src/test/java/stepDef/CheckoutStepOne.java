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

public class CheckoutStepOne extends env_target {
    @Given("User in product page")
    public void userInProductPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(productsUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(productsUrl)
        );
    }

    @When("User click product add to cart button")
    public void userClickProductAddToCartButton() {
        List<WebElement> multipleclick = driver.findElements(By.className("btn_inventory"));

        for (WebElement addtocart : multipleclick) {
            addtocart.click();
        }
    }

    @And("User click a cart icon")
    public void userClickACartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("Website will be direct to cart page and display product")
    public void websiteWillBeDirectToCartPageAndDisplayProduct() {
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

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.className("checkout_button")).click();
    }

    @Then("Website will direct to checkout page")
    public void websiteWillDirectToCheckoutPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-one.html"),
                        ExpectedConditions.textToBe(By.className("subheader"),"Checkout: Your Information")
                )
        );
    }

    @And("User click the cancel button")
    public void userClickTheCancelButton() {
        driver.findElement(By.className("cart_cancel_link")).click();
    }

    @Then("Website will display cancel checkout validation")
    public void websiteWillDisplayCancelCheckoutValidation() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("cancel-checkout-validation"))
        );
    }

    @And("User click keep checkout in cancel checkout validation")
    public void userClickKeepCheckoutInCancelCheckoutValidation() {
        driver.findElement(By.className("keepcheckout_validation_button")).click();
    }

    @Then("User can continue checkout and still in the same page")
    public void userCanContinueCheckoutAndStillInTheSamePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-one.html")
        );
        driver.quit();
    }

    @And("User click cancel in cancel checkout validation")
    public void userClickCancelInCancelCheckoutValidation() {
        driver.findElement(By.className("cancel_validation_button")).click();
    }

    @Then("User successfully cancel the checkout")
    public void userSuccessfullyCancelTheCheckout() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/cart.html")
        );
        driver.quit();
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.className("cart_button")).click();
    }

    @Then("User get error data required")
    public void userGetErrorDataRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"),"Error: Data is required")
        );
        driver.quit();
    }

    @And("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("firstname");
    }

    @Then("User get error first name required")
    public void userGetErrorFirstNameRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"),"Error: First Name is required")
        );
        driver.quit();
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("lastname");
    }

    @Then("User get error last name required")
    public void userGetErrorLastNameRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"),"Error: Last Name is required")
        );
        driver.quit();
    }

    @And("User input zip code")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("123");
    }

    @Then("User get error first zip code required")
    public void userGetErrorFirstZipCodeRequired() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3"),"Error: Postal Code is required")
        );

        driver.quit();
    }

    @Then("Website will be direct to checkout two page and display product results")
    public void websiteWillBeDirectToCheckoutTwoPageAndDisplayProductResults() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-two.html"),
                        ExpectedConditions.textToBe(By.className("subheader"),"Checkout: Overview"),
                        ExpectedConditions.visibilityOfElementLocated(By.className("cart_list")),
                        ExpectedConditions.textToBe(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]"),"Shipping Information:")
                )
        );
        driver.quit();
    }


}
