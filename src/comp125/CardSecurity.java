package comp125;

import java.util.Scanner;

public class CardSecurity {

	public static void main(String[] args) {
		// Example values
		String testNum1 = "1234567890";
		String testNum3 = "1653467845368";
		String testNum4 = "";

		// Example check digits
		System.out.println("Check digit for first num is "
				+ checkDigit(testNum1) + ".");
		System.out.println("Check digit for third num is "
				+ checkDigit(testNum3) + ".");
		System.out.println("Check digit for fourth num is "
				+ checkDigit(testNum4) + ".");

		// Example CSC
		System.out.println("Card sec code for first num is "
				+ cardSecCode(testNum1, 3, 5) + ".");
		System.out.println("Card sec code for third num is "
				+ cardSecCode(testNum3, 3, 5) + ".");
		System.out.println("Card sec code for fourth num is "
				+ cardSecCode(testNum4, 3, 5) + ".");

		// User input for numeric check
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Entered string is " + userInput(keyboard) + ".");
		keyboard.close();
	}

	// Checks the string entered by the user for non-numerical characters and
	// length.
	public static String userInput(Scanner keyboard) {
		System.out.print("Please enter a string to check if it's numeric: ");
		String userString = keyboard.nextLine();
		while (!isNumeric(userString)) {
			System.out
					.print("Non-numeric characters detected or number is too long. Please try again: ");
			userString = keyboard.nextLine();
		}
		return userString;
	}

	// Check string for non-numerical characters and length.
	public static boolean isNumeric(String cardNum) {

		if (cardNum == null || cardNum.length() > 16)
			return false;

		// Checks each digit for non-numerical char.
		for (int i = 0; i < cardNum.length(); i++)
			if (!(cardNum.charAt(i) >= '0' && cardNum.charAt(i) <= '9'))
				return false;
		return true;
	}

	public static int checkDigit(String cardNum) {

		// Odd length numbers require different work at the end of the loop.
		boolean isEvenLength = (cardNum.length() % 2 == 0);

		String cardNumNew = "";

		// Every odd numbered pair (1, 3, 5...) is reversed and added, even
		// pairs are simply added
		for (int i = 0; i < cardNum.length(); i += 2) {
			if (isEvenLength || i < cardNum.length() - 1) {
				if (i % 4 == 0) {
					cardNumNew += cardNum.charAt(i + 1);
					cardNumNew += cardNum.charAt(i);
				} else {
					cardNumNew += cardNum.charAt(i);
					cardNumNew += cardNum.charAt(i + 1);
				}
			} else {
				cardNumNew += cardNum.charAt(i); // if there is one left over, it just gets put on the end.
			}
		}

		int total = 0;

		for (int i = 0; i < cardNumNew.length(); i += 2) {

			String temp = "";

			// Adds the pair or only char left to the temp string.
			if (isEvenLength || i < cardNumNew.length() - 1) {
				temp += cardNumNew.charAt(i);
				temp += cardNumNew.charAt(i + 1);
			} else {
				temp += cardNumNew.charAt(i);
			}

			// Adds int version of temp to the total.
			total += Integer.parseInt(temp);
		}

		// calculate and return checkDigit.
		return total % 10;
	}

	public static String encrypt(String cardNum, int k1, int k2) {
		// Checks that cardNum is a number and contains something, and that k1 and k2 are valid.
		if (!isNumeric(cardNum) || cardNum.length() < 1 || k1 < 0 || k1 > 9
				|| k2 < 0 || k2 > 9)
			return "";

		String cryptogram = "";
		
		// Main encryption loop
		for (int i = 0; i < cardNum.length(); i++) {
			char digitChar = cardNum.charAt(i);
			int digitValue = (int) digitChar - (int) '0';  //each number is converted to integer
			digitValue = ((k1 * digitValue) + k2) % 10;    //encrypted
			digitChar = (char) ((int) ('0') + digitValue); //converted back to char
			cryptogram += digitChar;					   //and stored in the string
		}

		return cryptogram;
	}

	public static String cardSecCode(String cardNum, int k1, int k2) {
		
		//Encrypt the string
		String cryptogram = encrypt(cardNum, k1, k2);
		
		//This can't work with an empty string
		if (cryptogram == "")
			return "";
		
		//Convert the string into a number, then into a hex string.
		long hex = Long.parseLong(cryptogram);
		String cryptoHex = Long.toHexString(hex);

		String CSC = "";
		
		//Pull the first three integers out of the hex string and put them in the CSC string
		for (int i = 0, k = 0; k < 3; i++) {
			if (cryptoHex.charAt(i) >= '0' && cryptoHex.charAt(i) <= '9') {
				CSC += cryptoHex.charAt(i);
				k++;
			}
		}

		return CSC;
	}
	
	// 3 assignments due the same weekend, no thank you.
	public static String decrypt(String cryptogram, int k1, int k2) {
		return "";
	}

}