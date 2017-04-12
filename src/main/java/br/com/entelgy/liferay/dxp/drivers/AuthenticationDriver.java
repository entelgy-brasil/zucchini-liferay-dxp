package br.com.entelgy.liferay.dxp.drivers;

import br.com.entelgy.GenericDriver;
import br.com.entelgy.liferay.dxp.constants.Wait;
import br.com.entelgy.liferay.dxp.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationDriver extends GenericDriver {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationDriver.class);

	protected static final String PORTAL_URL = "c/portal/";
	protected static final String LOGOUT_URL = PORTAL_URL + "logout";
	protected static final String LOGIN_URL = PORTAL_URL + "login";

    public static WebElement login(String username, String password) {
		try {

			getWebDriver().get(applicationContext.getServerUrl() + LOGIN_URL);

			if (!applicationContext.getUsername().isEmpty()) {
				if (!applicationContext.getUsername().equals(username)) {
					logout();
				}
			}

			if (applicationContext.getUsername().isEmpty()) {

				getWebDriver().get(applicationContext.getServerUrl() + LOGIN_URL);

				LoginPage page = PageFactory.initElements(getWebDriver(), LoginPage.class);
				page.setDriver(getWebDriver());

				page.login(username, password);

				applicationContext.setUsername(username);
			}

			return new WebDriverWait(getWebDriver(), Wait.THIRTY_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className("user-avatar-image")));

		} catch (NoSuchElementException ex) {
			LOG.error("Avatar element is not found.");
			return null;
		}
	}

	public static void logout() {
		getWebDriver().get(applicationContext.getServerUrl() + LOGOUT_URL);
		applicationContext.setUsername("");

	}
}
