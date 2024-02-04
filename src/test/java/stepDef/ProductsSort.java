package stepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.env_target;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsSort extends env_target {
    @Given("User on login page")
    public void userOnLoginPage() {
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

    @When("User insert username and password")
    public void userInsertUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Website will be direct to the products page")
    public void websiteWillBeDirectToTheProductsPage() {
        Duration duration = Duration.ofSeconds(8);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/inventory.html")
        );
    }

    @And("User click sort menu")
    public void userClickSortMenu() {
        driver.findElement(By.className("product_sort_container")).click();
    }

    @Then("User do filter name a to z")
    public void userDoFilterNameAToZ() throws InterruptedException {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<String> beforeFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : beforeFilterNameAToZ) {
            beforeFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (A to Z)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : afterFilterNameAToZ) {
            afterFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterNameListAToZ); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterNameListAToZ, afterFilterNameListAToZ);

        Thread.sleep(2000);

        driver.quit();
    }

    @Then("User do filter name z to a")
    public void userDoFilterNameZToA() throws InterruptedException {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<String> beforeFilterNameListZToA = new ArrayList<>();

        for (WebElement ztoa : beforeFilterNameZToA) {
            beforeFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (Z to A)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListZToA = new ArrayList<>();

        for (WebElement ztoa : afterFilterNameZToA) {
            afterFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.reverse(beforeFilterNameListZToA); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterNameListZToA, afterFilterNameListZToA);

        Thread.sleep(2000);

        driver.quit();
    }

    @Then("User do filter price low to high")
    public void userDoFilterPriceLowToHigh() throws InterruptedException {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : beforeFilterPriceLoToHi) {
            beforeFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : afterFilterPriceLoToHi) {
            afterFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListLoToHi); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterPriceListLoToHi, afterFilterPriceListLoToHi);

        Thread.sleep(2000);

        driver.quit();
    }

    @Then("User do filter price high to low")
    public void userDoFilterPriceHighToLow() throws InterruptedException {
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : beforeFilterPriceHiLo) {
            beforeFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : afterFilterPriceHiLo) {
            afterFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListHiLo);
        Collections.reverse(beforeFilterPriceListHiLo); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterPriceListHiLo, afterFilterPriceListHiLo);

        Thread.sleep(2000);

        driver.quit();
    }
}
