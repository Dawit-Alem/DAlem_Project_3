package application;


import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerStudentTest {

	@Test
    public void testIsStringInBounds() {
        // Test case 1: Valid characters within bounds
        assertTrue("Expected true for 'HELLO'", CryptoManager.isStringInBounds("HELLO"));

        // Test case 2: Contains an out-of-bounds character (e.g., '!')
        assertFalse("Expected false for 'Hello World!'", CryptoManager.isStringInBounds("Hello World!"));

        // Test case 3: Contains a lowercase character (which is out of bounds)
        assertFalse("Expected false for 'dawit'", CryptoManager.isStringInBounds("dawit"));
    }

	@Test
    public void testCaesarEncryption() {
        // Test case: Basic encryption with a valid input
        String plainText = "DAWIT";
        int key = 3; // Shift by 3
        String expected = "GDZLW"; // Expected encrypted output
        String actual = CryptoManager.caesarEncryption(plainText, key);
        assertEquals("Expected GDZLW for input DAWIT with key 3", expected, actual);
    }

	@Test
    public void testCaesarDecryption() {
        // Test case: Basic decryption with a valid input
        String encryptedText = "GDZLW"; // Correct encrypted string
        int key = 3;                     // Shift key used for encryption
        String expected = "DAWIT";      // Expected decrypted output
        String actual = CryptoManager.caesarDecryption(encryptedText, key);
        
        // Assert that the actual output matches the expected output
        assertEquals("Expected DAWIT for input GDZLW with key 3", expected, actual);
    }

    @Test
    public void testBellasoEncryption() {
        // Test case: Basic encryption with a valid input
        String plainText = "DAWIT";            // Input string
        String bellasoStr = "ALEM";             // Bellaso key
        String expected = "%-<65";              // Expected encrypted output
        String actual = CryptoManager.bellasoEncryption(plainText, bellasoStr);
        
        // Assert that the actual output matches the expected output
        assertEquals("Expected %%-<65 for input DAWIT with Bellaso key ALEM", expected, actual);
    }

    @Test
    public void testBellasoDecryption() {
        // Test case: Decrypting an encrypted string with a valid Bellaso key
        String encryptedText = "%-<65"; // Example encrypted text
        String bellasoStr = "ALEM";      // Bellaso key used for encryption
        String expected = "DAWIT";       // Expected decrypted output
        String actual = CryptoManager.bellasoDecryption(encryptedText, bellasoStr);
        
        // Assert that the actual output matches the expected output
        assertEquals("Expected DAWIT for input %-<65 with Bellaso key ALEM", expected, actual);
    }
}
