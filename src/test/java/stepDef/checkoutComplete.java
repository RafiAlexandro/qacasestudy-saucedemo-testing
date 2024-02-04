package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class checkoutComplete extends env_target {
    @Given("User in a product page")
    public void userInAProductPage() {
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

    @When("User click all add to cart button")
    public void userClickAllAddToCartButton() {
        List<WebElement> multipleclick = driver.findElements(By.className("btn_inventory"));

        for (WebElement addtocart : multipleclick) {
            addtocart.click();
        }
    }

    @And("User click a cart icon button")
    public void userClickACartIconButton() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("Website direct to cart page and display product")
    public void websiteDirectToCartPageAndDisplayProduct() {
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

    @And("User click a checkout button")
    public void userClickACheckoutButton() {
        driver.findElement(By.className("checkout_button")).click();
    }

    @Then("Website direct to the checkout one page")
    public void websiteDirectToTheCheckoutOnePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-step-one.html")
        );
    }

    @And("User input the data user")
    public void userInputTheDataUser() {
        driver.findElement(By.id("first-name")).sendKeys("firstname");
        driver.findElement(By.id("last-name")).sendKeys("lastname");
        driver.findElement(By.id("postal-code")).sendKeys("123");
    }

    @And("User click a continue button")
    public void userClickAContinueButton() {
        driver.findElement(By.className("cart_button")).click();
    }

    @Then("Website direct to checkout two page with the product and results")
    public void websiteDirectToCheckoutTwoPageWithTheProductAndResults() {
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

    @And("User click the finish button")
    public void userClickTheFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
    }

    @Then("Website direct to checkout complete page")
    public void websiteDirectToCheckoutCompletePage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/checkout-complete.html"),
                        ExpectedConditions.textToBe(By.className("subheader"),"Finish")
                )
        );
    }

    @And("User click checkout another button")
    public void userClickCheckoutAnotherButton() {
        driver.findElement(By.className("checkout_another")).click();
    }

    @Then("Website direct to cart page")
    public void websiteDirectToCartPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
        driver.quit();
    }
}
