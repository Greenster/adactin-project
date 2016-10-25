/**
 * File Name: SearchHotel.java<br>
 * LastName, FirstName<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 24, 2016
 */
package com.sqa.lg.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

/**
 * SearchHotel //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 */
public class SearchHotel {

	private static WebDriver driver;

	@FindBy(id = "adult_room")
	WebElement adultsPerRoom;

	@FindBy(id = "datepick_in")
	WebElement checkInDate;

	@FindBy(id = "datepick_out")
	WebElement checkOutDate;

	@FindBy(id = "child_room")
	WebElement childrenPerRoom;

	@FindBy(id = "hotels")
	WebElement hotels;

	@FindBy(id = "location")
	WebElement location;

	@FindBy(id = "room_nos")
	WebElement numOfRooms;

	@FindBy(id = "Reset")
	WebElement resetBtn;

	@FindBy(id = "room_type")
	WebElement roomType;

	@FindBy(id = "Submit")
	WebElement submitBtn;

	/**
	 * @param driver
	 */
	public SearchHotel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SelectHotel search(String locationInput, String hotelsInput, String roomTypeInput, String numOfRoomsInput,
			String checkInDateInput, String checkOutDateInput, String adultsPerRoomInput, String childrenPerRoomInput) {

		Select locationSelect = new Select(this.location);
		locationSelect.selectByVisibleText(locationInput);

		Select hotelsSelect = new Select(this.hotels);
		hotelsSelect.selectByVisibleText(hotelsInput);

		Select roomTypeSelect = new Select(this.roomType);
		roomTypeSelect.selectByVisibleText(roomTypeInput);

		Select numOfRoomsSelect = new Select(this.numOfRooms);
		numOfRoomsSelect.selectByValue(numOfRoomsInput);

		this.checkInDate.clear();
		this.checkInDate.sendKeys(checkInDateInput);
		this.checkOutDate.clear();
		this.checkOutDate.sendKeys(checkOutDateInput);

		Select adultsPerRoomSelect = new Select(this.adultsPerRoom);
		adultsPerRoomSelect.selectByValue(adultsPerRoomInput);

		Select childrenPerRoomSelect = new Select(this.childrenPerRoom);
		childrenPerRoomSelect.selectByValue(childrenPerRoomInput);

		this.submitBtn.click();
		return new SelectHotel(driver);
	}
}
