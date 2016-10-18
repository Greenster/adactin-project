
package com.sqa.lg.helpers;

import java.util.*;

/**
 * RequestInput //ADDD (description of class)
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
public class RequestInput {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a boolean type variable.
	 *
	 * @return Boolean value based on user input
	 */
	public static boolean getBoolean(String question) {
		// Local variable to hold input
		String input;
		// Infinit loop to look out for Yes and No valid options
		while (true) {
			// Ask the user a question to get relative input
			System.out.print(question + " (Yes/Y) or (No/N):");
			// Set the input based on what the user enters on their keyboard
			input = scanner.nextLine();
			// Check if the user has entered Yes
			if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")) {
				// Return that the user has selected Yes so return true
				return true;
				// Check if the user has entered No
			} else if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")) {
				// Return that the user has selected No so return false
				return false;
				// Or else the user has not entered a valid option
			} else {
				// Return an error message to user
				System.out.println("You have not entered a valid option, please choose Yes/Y or No/N.");
				// Continue infinite loop to ask for a valid response
				continue;
			}
		}
	}

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a boolean type variable.
	 *
	 * @return Boolean value based on user input
	 */
	public static char getChar(String question) {
		// Local variable to hold input
		String input;
		char character = ' ';
		// Infinit loop to look out for valid options
		while (true) {
			try {
				// Ask the user a question to get relative input
				System.out.print(question);
				// Set the input based on what the user enters on their keyboard
				input = scanner.nextLine();
				// Check that the input String is one character long
				if (input.length() < 1) {
					System.out.println("UNDER:" + input.length());
					throw new IllegalArgumentException("too few chars, need at least one.");
				} else if (input.length() > 1) {
					System.out.println("OVER:" + input.length());
					throw new IllegalArgumentException("too many chars - should only have (" + input.charAt(0) + ")");
				}
				character = input.charAt(0);
				// Convert the String into a char value
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println("Print e);
				e.getMessage();
			}
			return character;
		}
	}

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a boolean type variable.
	 *
	 * @return Boolean value based on user input
	 */
	public static char getChar(String question, char... characters) {
		while (true) {
			// Declare Local Variables
			boolean present = false;
			// Get the character using alternative method to get a char
			char letter = RequestInput.getChar(question);
			// Iterate through the supplied chars and see if it is present
			for (int i = 0; i < characters.length; i++) {
				if (Character.compare(characters[i], letter) == 0) {
					present = true;
				}
			}
			// If present variable is set to true and it is a valid option
			if (present == true) {
				// return the character
				return letter;
			} else {
				// Give an error message
				System.out.println("You have not entered a valid character (" + letter + ").");
				// Continue with next iteration
				continue;
			}
		}
	}

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a Double type variable.
	 *
	 * @return Double value based on user input
	 */
	public static double getDouble(String question) {
		// Local variable to hold temporary number
		double num;
		//
		while (true) {
			try {
				// Ask the user a question to get relative input
				System.out.print(question);
				// Set the number based on what the user enters on their
				// keyboard
				num = Double.parseDouble(scanner.nextLine().trim());

				// Break out of the infinite loop
				break;
			} catch (NumberFormatException e) {
				// Output to the user that the number is not valid
				System.out.println("You have not entered a valid number.");
				// Continue the infinite loop to get a valid number conversion
				continue;
			}
		}
		// Return number of user has entered
		return num;
	}

	/**
	 * Static Helper Method which asks usera specified question and as long as
	 * they give a valid number will return the number as an int type variable.
	 *
	 * @return Number the user has chosen
	 */
	public static int getInt(String question) {
		// Local variable to hold temporary number
		int num;
		//
		while (true) {
			try {
				// Ask the user a question to get relative input
				System.out.print(question);
				// Set the number based on what the user enters on their
				// keyboard

				num = Integer.parseInt(scanner.nextLine().trim());

				// Break out of the infinite loop
				break;
			} catch (NumberFormatException e) {
				// Output to the user that the number is not valid
				System.out.println("You have not entered a valid number.");
				// Continue the infinite loop to get a valid number conversion
				continue;
			}
		}
		// Return number of pets user has entered
		return num;
	}

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a int type variable.
	 *
	 * @return int value based on user input
	 */
	public static int getInt(String question, int... acceptableNumber) {
		String input = null;
		int resultValue;
		boolean validInt = false;
		while (true) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultValue = Integer.parseInt(input);

				for (int i = 0; i < acceptableNumber.length; i++) {
					if (resultValue == acceptableNumber[i]) {
						validInt = true;
					}
				}
				if (!validInt) {
					throw new InvalidAcceptableNumberException();
				}
				return resultValue;

			} catch (NumberFormatException e) {
				System.out.println("You have not provided a valid integer type (" + input + ")");
				continue;
			} catch (InvalidAcceptableNumberException e) {
				System.out.println("You have not provided an acceptable valid number (" + input + ")");
			}
		}
	}

	/**
	 * @param string
	 * @param string2
	 * @param i
	 * @param j
	 * @return
	 */
	public static int getInt(String question, String unacceptableErrorMessage, int min, int max) {
		String input = null;
		int resultValue;
		boolean validInt = false;
		while (true) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultValue = Integer.parseInt(input);

				if (resultValue >= min && resultValue <= max) {
					validInt = true;
				}
				if (!validInt) {
					throw new InvalidAcceptableNumberException();
				}
				return resultValue;

			} catch (NumberFormatException e) {
				System.out.println("You have not provided a valid integer type (" + input + ")");
				continue;
			} catch (InvalidAcceptableNumberException e) {
				String message = String.format(unacceptableErrorMessage, min, max);
				System.out.println(message);
			}
		}
	}

	/**
	 * Static Helper Method which asks user specified question and return the
	 * input to user.
	 *
	 * @return Input given from user.
	 */
	public static String getString(String question) {
		// Local variable to hold temporary number
		String input;
		// Reinitialize Scanner object
		scanner = new Scanner(System.in);
		// Ask the user a question to get relative input
		System.out.print(question);
		// Set the number based on what the user enters on their
		// keyboard
		input = scanner.nextLine();
		// Return input user has entered
		return input;
	}

	/**
	 * Static Helper Method which asks user specified question and as long as
	 * they give a input will return a boolean type variable.
	 *
	 * @return Boolean value based on user input
	 */
	public static String getString(String question, String... acceptableWords) {
		String input = null;
		String resultValue;
		boolean validWord = false;
		while (true) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultValue = input;

				for (int i = 0; i < acceptableWords.length; i++) {
					if (resultValue.trim().replace(" ", "").equalsIgnoreCase(acceptableWords[i])) {
						validWord = true;
					}
				}
				if (!validWord) {
					throw new InvalidAcceptableWordException();
				}
				return resultValue;
			} catch (InvalidAcceptableWordException e) {
				System.out.println("You have not provided an acceptable word (" + input + ")");
			}
		}
	}
	// Create your own helper method that you may find useful

	/**
	 * @param question
	 * @Param cancellationMessage
	 * @param acceptableWords
	 * @return
	 */
	public static String getString(String question, String cancellationMessage, Enum... acceptableEnum) {
		String input = null;
		String resultValue;
		String resultString = "";
		boolean validWord = false;
		while (true) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultValue = input;

				for (int i = 0; i < acceptableEnum.length; i++) {
					if (resultValue.trim().equalsIgnoreCase(acceptableEnum[i].toString())) {
						validWord = true;
						resultString += acceptableEnum[i].toString();
					}
				}
				if (!validWord) {
					throw new InvalidAcceptableWordException();
				}
				return resultString;
			} catch (InvalidAcceptableWordException e) {
				System.out.println("You have not provided an acceptable word (" + input + ")");
				System.out.print("You must provide one of the following options: ");
				for (int i = 0; i < acceptableEnum.length; i++) {
					System.out.print(acceptableEnum[i].toString());
					if (i != acceptableEnum.length - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();

				String message = String.format(cancellationMessage, input);
				System.out.println(message);

				System.out.println("If you would like to cancel, enter '*' or just press enter to continue:");
				input = scanner.nextLine();
				if (input.equalsIgnoreCase("*")) {
					return resultString;
				}
			}
		}
	}
}
