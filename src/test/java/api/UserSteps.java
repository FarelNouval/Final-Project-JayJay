package api;

import api.ApiClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class UserSteps {

    Response response;
    String userId = "60d0fe4f5311236168a109ca";
    String createdUserId;

    @Given("User has valid user id {string}")
    public void user_has_valid_id(String id) {
        userId = id;
    }

    @When("Send GET request using created user id")
    public void get_created_user() {
        response = ApiClient.request()
                .get("/user/" + createdUserId);
    }

    @When("Send POST request to create user")
    public void send_post_user() {

        Map<String, String> body = new HashMap<>();
        body.put("firstName", "QA");
        body.put("lastName", "Automation");
        body.put("email", "qa" + System.currentTimeMillis() + "@mail.com");

        response = ApiClient.request()
                .body(body)
                .post("/user/create");

        createdUserId = response.jsonPath().getString("id");
    }

    @When("Send PUT request to update user")
    public void send_put_user() {

        Map<String, String> body = new HashMap<>();
        body.put("firstName", "Updated");

        response = ApiClient.request()
                .body(body)
                .put("/user/" + userId);
    }

    @When("Send DELETE request to delete user")
    public void send_delete_user() {
        response = ApiClient.request()
                .delete("/user/" + userId);
    }

    @When("Send GET request to get list of tags")
    public void send_get_tags() {
        response = ApiClient.request()
                .get("/tag");
    }

    @Then("Response status code should be {int}")
    public void validate_status_code(int status) {
        System.out.println("Response:");
        response.prettyPrint();
        Assert.assertEquals(status, response.getStatusCode());
    }

    @And("Save created user id")
    public void save_user_id() {
        createdUserId = response.jsonPath().getString("id");
    }


}