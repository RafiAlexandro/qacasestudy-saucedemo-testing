package stepDef;

import config.env_target;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutStepTwo extends env_target {
    @Given("User in the product page")
    public void userInTheProductPage() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(productsUrl);
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe(productsUrl)
        );
    }

    @When("User click the product add to cart button")
    public void userClickTheProductAddToCartButton() {
        List<WebElement> multipleclick = driver.findElements(By.className("btn_inventory"));

        for (WebElement addtocart : multipleclick) {
            addtocart.click();
        }
    }

    @And("User click cart icon button")
    public void userClickCartIconButton() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("Website will direct to cart page and display product")
    public void websiteWillDirectToCartPageAndDisplayProduct() {
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

    @And("User click the checkout button")
    public void userClickTheCheckoutButton() {
        driver.findElement(By.className("checkout_button")).click();
    }

    @Then("Website will direct to the checkout one page")
    public void websiteWillDirectToTheCheckoutOnePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-one.html")
        );
    }

    @And("User input data user")
    public void userInputDataUser() {
        driver.findElement(By.id("first-name")).sendKeys("firstname");
        driver.findElement(By.id("last-name")).sendKeys("lastname");
        driver.findElement(By.id("postal-code")).sendKeys("123");
    }

    @And("User click the continue button")
    public void userClickTheContinueButton() {
        driver.findElement(By.className("cart_button")).click();
    }

    @Then("Website in checkout two page with the product and results")
    public void websiteInCheckoutTwoPageWithTheProductAndResults() {
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
    }

    @And("User click cancel in checkout two page")
    public void userClickCancelInCheckoutTwoPage() {
        driver.findElement(By.className("cart_cancel_link")).click();
    }

    @Then("Website will display cancel checkout step two validation")
    public void websiteWillDisplayCancelCheckoutStepTwoValidation() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("cancel_validation"))
        );
        driver.quit();
    }

    @And("User click cancel in cancel checkout step two validation")
    public void userClickCancelInCancelCheckoutStepTwoValidation() {
        driver.findElement(By.className("cancel_validation_btn")).click();
    }

    @Then("User success cancel the checkout step two and direct to product page")
    public void userSuccessCancelTheCheckoutStepTwoAndDirectToProductPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
        driver.quit();
    }

    @And("User click keep checkout in cancel checkout step two validation")
    public void userClickKeepCheckoutInCancelCheckoutStepTwoValidation() {
        driver.findElement(By.className("keepcheckout_validation_btn")).click();
    }

    @Then("User success keep the checkout and still in checkout step two page")
    public void userSuccessKeepTheCheckoutAndStillInCheckoutStepTwoPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-two.html")
        );
        driver.quit();
    }

    @And("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
    }

    @Then("Website will be direct to checkout complete page")
    public void websiteWillBeDirectToCheckoutCompletePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                    ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-complete.html"),
                    ExpectedConditions.textToBe(By.className("subheader"),"Finish")
                )
        );
        driver.quit();
    }
}
