package application;

/* 
 Class: CMSC 203 CRN 22824
 Program: Assignment #3
 Instructor: Prof. Ahmed Tarek
 Summary of Description: Encryption and Decryption 
 Due Date: 10/15/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student’s Name: Dawit Alem
 */


public class CryptoManager {
	
    // ASCII bounds constants
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	
	/**
     * Checks if the given plain text string is within the defined ASCII bounds.
     * 
     * @param plainText The input string to check.
     * @return true if all characters are within bounds; false otherwise.
     */
	public static boolean isStringInBounds(String plainText) {
	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
     * Encrypts the given plain text using Caesar cipher.
     * 
     * @param plainText The text to encrypt.
     * @param key The shift key for the encryption.
     * @return The encrypted text or an error message if the input is out of bounds.
     */
	public static String caesarEncryption(String plainText, int key) {
	    // Check if the string is within bounds
	    if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }

	    StringBuilder encryptedText = new StringBuilder();

	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        // Shift character by the key, wrap around using modulo
	        char encryptedChar = (char) ((ch + key - LOWER_RANGE) % RANGE + LOWER_RANGE);
	        encryptedText.append(encryptedChar);
	    }

	    return encryptedText.toString();
	}
	
	
	/**
     * Encrypts the given plain text using the Bellaso method.
     * 
     * @param plainText The text to encrypt.
     * @param bellasoStr The Bellaso key used for encryption.
     * @return The encrypted text or an error message if the input is out of bounds.
     */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
	    if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }

	    StringBuilder encryptedText = new StringBuilder();

	    for (int i = 0; i < plainText.length(); i++) {
	        char plainChar = plainText.charAt(i);
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());  // Repeat bellasoStr if necessary

	        // Encrypt using Bellaso formula and wrap within range
	        int encryptedValue = plainChar + bellasoChar - 2 * LOWER_RANGE;
	        if (encryptedValue > RANGE) {
	            encryptedValue = (encryptedValue % RANGE) + LOWER_RANGE;
	        }

	        char encryptedChar = (char) (encryptedValue);
	        encryptedText.append(encryptedChar);
	    }

	    return encryptedText.toString();
	}

	/**
     * Decrypts the given encrypted text using the Caesar cipher.
     * 
     * @param encryptedText The text to decrypt.
     * @param key The shift key used during encryption.
     * @return The decrypted text.
     */
	public static String caesarDecryption(String encryptedText, int key) {
	    StringBuilder decryptedText = new StringBuilder();

	    for (int i = 0; i < encryptedText.length(); i++) {
	        char ch = encryptedText.charAt(i);
	        // Reverse the shift and wrap around using modulo
	        char decryptedChar = (char) ((ch - key - LOWER_RANGE + RANGE) % RANGE + LOWER_RANGE);
	        decryptedText.append(decryptedChar);
	    }

	    return decryptedText.toString();
	}
	
	/**
     * Decrypts the given encrypted text using the Bellaso method.
     * 
     * @param encryptedText The text to decrypt.
     * @param bellasoStr The Bellaso key used for decryption.
     * @return The decrypted text.
     */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	    StringBuilder decryptedText = new StringBuilder();

	    for (int i = 0; i < encryptedText.length(); i++) {
	        char encryptedChar = encryptedText.charAt(i);
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());

	        // Decrypt using Bellaso formula
	        int decryptedValue = encryptedChar - bellasoChar;

	        // If the decrypted value is less than LOWER_RANGE, we need to wrap around
	        if (decryptedValue < 0) {
	            decryptedValue += RANGE;
	        }

	        // Add LOWER_RANGE to bring it back into valid ASCII bounds
	        char decryptedChar = (char) (decryptedValue + LOWER_RANGE);

	        decryptedText.append(decryptedChar);
	    }

	    return decryptedText.toString();
	}

}
