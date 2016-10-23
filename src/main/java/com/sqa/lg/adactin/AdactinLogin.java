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
	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(id = "password")
	WebElement passwordFld;

	@FindBy(id = "username")
	WebElement usernameFld;

	public AdactinLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		this.usernameFld.clear();
		this.usernameFld.sendKeys(username);
		this.passwordFld.clear();
		this.passwordFld.sendKeys(password);
		this.loginBtn.click();
	}
}
