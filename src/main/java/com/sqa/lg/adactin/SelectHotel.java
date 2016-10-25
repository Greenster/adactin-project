/**
 *   File Name: SelectHotel.java<br>
 *
 *   Green, Lorne<br>
 *   Java <br>
 *   <br>
 *   Created: Oct 24, 2016
 *
 */

package com.sqa.lg.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * SelectHotel //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Green, Lorne
 * @version 1.0.0
 * @since 1.0
 *
 */
public class SelectHotel {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public SelectHotel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
