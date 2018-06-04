package testing;

import static org.junit.Assert.*;

import org.junit.*;

public class AccountTest extends junit.framework.TestCase {
	Account account;
	double epsilon = 0.5;
	
	@Before 
	public void setUp(){
		account = new Account(100,0.5);
	}
	
	
	public void testConstructor() {
		assertEquals(100.0, account.getBalance());
		assertEquals(0.5, account.getInterestRate());
	}
	
	public void testSetInterestRate() {
		account.setInterestRate(10);
		assertEquals(10.0, account.getInterestRate(), epsilon);
		try {
			account.setInterestRate(-2.0);
			fail("Account can not have negative interest rate");
		} catch (IllegalArgumentException e) {
			assertEquals(10.0, account.getInterestRate(), epsilon);
		} catch (Exception e) {
			fail("Expected, was " + e.getClass());
		}
	}
	public void testDeposit() {
		account.deposit(500);
		assertEquals(600.0, account.getBalance());
		
	}
	
	public void testWithdraw() {
		account.withdraw(100);
		assertEquals(0.0,account.getBalance());
		account.withdraw(-200);
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
