package web;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web.LoginPage;
import hooks.WebHooks;

public class LoginSteps {

    WebDriver driver = WebHooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is on login page")
    public void user_is_on_login_page(){
        loginPage.openPage();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials(){
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_credentials(){
        loginPage.inputUsername("invalid_user");
        loginPage.inputPassword("wrong_password");
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to homepage")
    public void user_redirected_homepage() {
        Assert.assertTrue(loginPage.isOnHomePage());
    }

    @Then("Error message should be displayed")
    public void error_message_displayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Given("User is logged in successfully")
    public void user_logged_in_successfully() {
        loginPage.openPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
    }
}
