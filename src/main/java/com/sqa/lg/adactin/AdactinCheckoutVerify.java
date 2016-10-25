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

public class AdactinCheckoutVerify {
	@FindBy(id = "datepick_in")
	WebElement checkInDate;

	@FindBy(id = "datepick_out")
	WebElement checkOutDate;

	/*
	 * @FindBy(id = "location") WebElement cityFld;
	 * 
	 * @FindBy(id = "hotels") WebElement hotelFld;
	 */

	@FindBy(id = "login")
	WebElement loginBtn;
	/*
	 * @FindBy(id = "room_nos") WebElement numberOfRoomFld;
	 */
	@FindBy(id = "password")
	WebElement passwordFld;
	/*
	 * @FindBy(id = "room_type") WebElement roomTypeFld;
	 */

	@FindBy(id = "Submit")
	WebElement searchBtn;

	@FindBy(id = "username")
	WebElement usernameFld;

	public AdactinCheckoutVerify(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void datePicker(String datepick_in, String datepick_out) {
		this.checkInDate.clear();
		this.checkInDate.sendKeys(datepick_in);
		this.checkOutDate.clear();
		this.checkOutDate.sendKeys(datepick_out);
		this.searchBtn.click();
	}

	/*
	 * public void locationPicker(String location, String hotels, String
	 * room_type, String room_nos) { this.cityFld.clear();
	 * this.cityFld.sendKeys(location); this.hotelFld.clear();
	 * this.hotelFld.sendKeys(hotels); this.roomTypeFld.clear();
	 * this.roomTypeFld.sendKeys(room_type); this.numberOfRoomFld.clear();
	 * this.numberOfRoomFld.sendKeys(room_nos); }
	 */

	public void login(String username, String password) {
		this.usernameFld.clear();
		this.usernameFld.sendKeys(username);
		this.passwordFld.clear();
		this.passwordFld.sendKeys(password);
		this.loginBtn.click();
	}
}
