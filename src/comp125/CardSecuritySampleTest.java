package comp125;
import static org.junit.Assert.*;
import org.junit.Test;

public class CardSecuritySampleTest {
	
	@Test
	public void test1IsNumeric() {
		String testNum1 = "1234567890";
		assertEquals(true, CardSecurity.isNumeric(testNum1));
	}
	
	@Test
	public void test2IsNumeric() {
		String testNum2 = "1234a567890";
		assertEquals(false, CardSecurity.isNumeric(testNum2));
	}
	
	@Test
	public void test4IsNumeric() {
		String testNum4 = "";
		assertEquals(true, CardSecurity.isNumeric(testNum4));
	}
	
	@Test
	public void test1CheckDigit() {
		String testNum1 = "1234567890";
		assertEquals(7, CardSecurity.checkDigit(testNum1));
	}
	
	@Test
	public void test3CheckDigit() {
		String testNum3 = "1653467845368";
		assertEquals(4, CardSecurity.checkDigit(testNum3));
	}
	
	@Test
	public void testEncrypt() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String cryptoNum1 = "8147036925";
		assertTrue(cryptoNum1.equals(CardSecurity.encrypt(testNum1,  k1,  k2)));
	}
	
	@Test
	public void testCardSecCode() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String code1 = "159";
		assertTrue(code1.equals(CardSecurity.cardSecCode(testNum1,  k1,  k2)));
	}
	
	@Test
	public void testDecrypt() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String cryptoNum1 = "8147036925";
		assertTrue(testNum1.equals(CardSecurity.decrypt(cryptoNum1,  k1,  k2)));
	}

}
