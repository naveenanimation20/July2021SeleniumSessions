package testngfeatures;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestEnableDisable {

	@Test
	public void createUserTest() {
		System.out.println("crate user");
	}

	@Test
	public void updateUserTest() {
		System.out.println("update user");
	}

	@Test(enabled = true)
	public void deleteUserTest() {
		System.out.println("delete user");
	}

	@Ignore
	@Test(enabled = true, description = "get user test for amazon app....")
	public void getUserTest() {
		System.out.println("get user");
	}

}
