package web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class InventoryPage {

    WebDriver driver;
    WebDriverWait wait;

    By inventoryItems = By.className("inventory_item");
    By cartBadge = By.className("shopping_cart_badge");
    By filterDropdown = By.className("product_sort_container");
    By productPrices = By.className("inventory_item_price");
    By productNames = By.className("inventory_item_name");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCart(String productName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("inventory_list")
        ));


        String formattedName = productName
                .toLowerCase()
                .replace(" ", "-");

        String buttonId = "add-to-cart-" + formattedName;

        By addToCartButton = By.id(buttonId);

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void selectFilter(String filterOption) {
        Select select = new Select(driver.findElement(filterDropdown));
        select.selectByVisibleText(filterOption);
    }

    public List<Double> getProductPrices() {
        return driver.findElements(productPrices)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public List<String> getProductNames() {
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void logout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));


        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("saucedemo.com");
    }
}
