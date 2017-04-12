package br.com.entelgy.liferay.dxp.steps;

import br.com.entelgy.liferay.dxp.drivers.AuthenticationDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

public class AuthenticationSteps {

	public static final String DEFAULT_PASSWORD = "test";
    public static final String DEFAULT_USER = "test@liferay.com";
    public static final String AVATAR_ELEMENT_IS_NOT_FOUND = "Avatar element is not found.";

    @Given("^user Test is logged in liferay$")
	@Then("^I log in as Test in liferay")
	public void loginUser() {
		WebElement avatarElement = AuthenticationDriver.login(DEFAULT_USER, DEFAULT_PASSWORD);
		assertNotNull(AVATAR_ELEMENT_IS_NOT_FOUND, avatarElement);
	}

    @Given("^user \"(.+)\" and password \"(.+)\" is logged in liferay$")
    @Then("^I log in as \"(.+)\" and password \"(.+)\" in liferay$")
    public void loginUserAndPass(String username, String password) {
        WebElement avatarElement = AuthenticationDriver.login(username, password);
        assertNotNull(AVATAR_ELEMENT_IS_NOT_FOUND, avatarElement);
    }

	@Then("^I logout in liferay$")
	public void logout() {
		AuthenticationDriver.logout();
	}

}
