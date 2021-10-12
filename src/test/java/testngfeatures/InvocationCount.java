package testngfeatures;

import org.testng.annotations.Test;

public class InvocationCount {
	
	
	@Test(invocationCount = 10)
	public void createUserTest() {
		System.out.println("crate user");
	}
	
	
	@Test(invocationCount = 100)
	public void getUserTest() {
		System.out.println("get user");
	}

}
