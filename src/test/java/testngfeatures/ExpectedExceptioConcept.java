package testngfeatures;

import org.testng.annotations.Test;

public class ExpectedExceptioConcept {
	String name = "JAVA";
	
	@Test(expectedExceptions = {NullPointerException.class, ArithmeticException.class})
	public void createUserTest() {

		System.out.println("create user test");
		int i = 9/3;
		
		ExpectedExceptioConcept obj = new ExpectedExceptioConcept();
		obj = null;
		System.out.println(obj.name);//NPE
	
	}
	
	@Test(expectedExceptions = Exception.class)
	public void UserTest() {

		System.out.println("create user test");
		int i = 9/3;
		
		ExpectedExceptioConcept obj = new ExpectedExceptioConcept();
		obj = null;
		System.out.println(obj.name);//NPE
	
	}
	
	
	
	

}
