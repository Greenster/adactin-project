/**
 *   File Name: AdactinLogin.java<br>
 *
 *   Green, Lorne<br>
 *   Java <br>
 *   <br>
 *   Created: Oct 22, 2016
 *
 */

package com.sqa.lg.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AdactinLogin {

	private static WebDriver driver;
	@FindBy(id = "login")
	private WebElement loginBtn;

	@FindBy(id = "password")
	private WebElement passwordFld;

	@FindBy(id = "username")
	private WebElement usernameFld;

	public AdactinLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchHotel login(String username, String password) {
		this.usernameFld.clear();
		this.usernameFld.sendKeys(username);
		this.passwordFld.clear();
		this.passwordFld.sendKeys(password);
		this.loginBtn.click();
		return new SearchHotel(driver);
	}
}
