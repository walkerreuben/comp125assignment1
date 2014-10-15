package comp125;
import static org.junit.Assert.*;
import org.junit.Test;

public class CardSecurityFinalTest {
	
	@Test(timeout=3000)
	// @Graded(description="test1IsNumeric", marks=1)
	public void test1IsNumeric() {
		String testNum1 = "1234567890";
		assertEquals(true, CardSecurity.isNumeric(testNum1));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test2IsNumeric", marks=1)
	public void test2IsNumeric() {
		String testNum2 = "1234a567890";
		assertEquals(false, CardSecurity.isNumeric(testNum2));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test3IsNumeric", marks=1)
	public void test3IsNumeric() {
		String testNum3 = "9";
		assertEquals(true, CardSecurity.isNumeric(testNum3));
	}
	@Test(timeout=3000)
	// @Graded(description="test4IsNumeric", marks=1)
	public void test4IsNumeric() {
		String testNum4 = "";
		assertEquals(true, CardSecurity.isNumeric(testNum4));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test5IsNumeric", marks=1)
	public void test5IsNumeric() {
		String testNum5 = "x123";
		assertEquals(false, CardSecurity.isNumeric(testNum5));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test6IsNumeric", marks=1)
	public void test6IsNumeric() {
		String testNum6 = "4582?";
		assertEquals(false, CardSecurity.isNumeric(testNum6));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test1CheckDigit", marks=1)
	public void test1CheckDigit() {
		String testNum1 = "1234567890";
		assertEquals(7, CardSecurity.checkDigit(testNum1));
	}
	@Test(timeout=3000)
	// @Graded(description="test2CheckDigit", marks=1)
	public void test2CheckDigit() {
		String testNum2 = "9";
		assertEquals(9, CardSecurity.checkDigit(testNum2));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test3CheckDigit", marks=1)
	public void test3CheckDigit() {
		String testNum3 = "1653467845368";
		assertEquals(4, CardSecurity.checkDigit(testNum3));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test4CheckDigit", marks=1)
	public void test4CheckDigit() {
		String testNum4 = "3215697843892165";
		assertEquals(2, CardSecurity.checkDigit(testNum4));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test5CheckDigit", marks=1)
	public void test5CheckDigit() {
		String testNum5 = "123";
		assertEquals(4, CardSecurity.checkDigit(testNum5));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test6CheckDigit", marks=1)
	public void test6CheckDigit() {
		String testNum6 = "11111";
		assertEquals(3, CardSecurity.checkDigit(testNum6));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test1Encrypt", marks=1)
	public void test1Encrypt() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String cryptoNum1 = "8147036925";
		assertTrue(cryptoNum1.equals(CardSecurity.encrypt(testNum1,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test2Encrypt", marks=1)
	public void test2Encrypt() {
		String testNum2 = "123";
		int k1 = 3; int k2 = 5;
		String cryptoNum2 = "814";
		assertTrue(cryptoNum2.equals(CardSecurity.encrypt(testNum2,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test3Encrypt", marks=1)
	public void test3Encrypt() {
		String testNum3 = "3215697843892165";
		int k1 = 3; int k2 = 5;
		String cryptoNum3 = "4180326974921830";
		assertTrue(cryptoNum3.equals(CardSecurity.encrypt(testNum3,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test4Encrypt", marks=1)
	public void test4Encrypt() {
		String testNum4 = "1234567890";
		int k1 = 7; int k2 = 3;
		String cryptoNum4 = "0741852963";
		assertTrue(cryptoNum4.equals(CardSecurity.encrypt(testNum4,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test5Encrypt", marks=1)
	public void test5Encrypt() {
		String testNum5 = "1653467845368";
		int k1 = 7; int k2 = 3;
		String cryptoNum5 = "0584152918459";
		assertTrue(cryptoNum5.equals(CardSecurity.encrypt(testNum5,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test6Encrypt", marks=1)
	public void test6Encrypt() {
		String testNum6 = "3215697843892165";
		int k1 = 7; int k2 = 3;
		String cryptoNum6 = "4708562914967058";
		assertTrue(cryptoNum6.equals(CardSecurity.encrypt(testNum6,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test1CardSecCode", marks=1)
	public void test1CardSecCode() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String code1 = "159";
		assertTrue(code1.equals(CardSecurity.cardSecCode(testNum1,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test2CardSecCode", marks=1)
	public void test2CardSecCode() {
		String testNum2 = "123";
		int k1 = 3; int k2 = 5;
		String code2 = "32";
		assertTrue(code2.equals(CardSecurity.cardSecCode(testNum2,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test3CardSecCode", marks=1)
	public void test3CardSecCode() {
		String testNum3 = "3215697843892165";
		int k1 = 3; int k2 = 5;
		String code3 = "938";
		assertTrue(code3.equals(CardSecurity.cardSecCode(testNum3,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test4CardSecCode", marks=1)
	public void test4CardSecCode() {
		String testNum4 = "1234567890";
		int k1 = 7; int k2 = 3;
		String code4 = "237";
		assertTrue(code4.equals(CardSecurity.cardSecCode(testNum4,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test5CardSecCode", marks=1)
	public void test5CardSecCode() {
		String testNum5 = "1653467845368";
		int k1 = 7; int k2 = 3;
		String code5 = "880";
		assertTrue(code5.equals(CardSecurity.cardSecCode(testNum5,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test6CardSecCode", marks=1)
	public void test6CardSecCode() {
		String testNum6 = "3215697843892165";
		int k1 = 7; int k2 = 3;
		String code6 = "106";
		assertTrue(code6.equals(CardSecurity.cardSecCode(testNum6,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test1Decrypt", marks=1)
	public void test1Decrypt() {
		String testNum1 = "1234567890";
		int k1 = 3; int k2 = 5;
		String cryptoNum1 = "8147036925";
		assertTrue(testNum1.equals(CardSecurity.decrypt(cryptoNum1,  k1,  k2)));
	}

	@Test(timeout=3000)
	// @Graded(description="testDecrypt2", marks=1)
	public void test2Decrypt() {
		String testNum2 = "3215697843892165";
		int k1 = 3; int k2 = 5;
		String cryptoNum2 = "4180326974921830";
		assertTrue(testNum2.equals(CardSecurity.decrypt(cryptoNum2,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test3Decrypt", marks=1)
	public void test3Decrypt() {
		String testNum3 = "1234567890";
		int k1 = 7; int k2 = 3;
		String cryptoNum3 = "0741852963";
		assertTrue(testNum3.equals(CardSecurity.decrypt(cryptoNum3,  k1,  k2)));
	}
	
	@Test(timeout=3000)
	// @Graded(description="test4Decrypt", marks=1)
	public void test4Decrypt() {
		String testNum4 = "1653467845368";
		int k1 = 7; int k2 = 3;
		String cryptoNum4 = "0584152918459";
		assertTrue(testNum4.equals(CardSecurity.decrypt(cryptoNum4,  k1,  k2)));
	}
	
}
