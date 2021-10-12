package testngfeatures;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	
	
	//tcs should always be independenct with eachother, do not create the dependecy b/w two test cases
	
	@Test
	public void loginTest() {
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("homePageTest ");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("searchTest");
	}
	
	
	//CRUD
	
	public void userCreate(String name, int age) {
		System.out.println(name + " " + age);
	}
	
	public void updateCreate(String name, int age) {
		System.out.println(name + " " + age);
	}
	
	public void deleteUser(String name, int age) {
		System.out.println(name + " " + age);
	}
	
	public void getUser(String name) {
		System.out.println(name);
	}
	
	
//	@Test
//	public void createUserTest() {
//		System.out.println("crate user");
//		userCreate("tom", 25);
//	}
//	
//	@Test(dependsOnMethods = "createUserTest")
//	public void updateUserTest() {
//		System.out.println("update user");
//		updateCreate("tom", 30);
//	}
	
	@Test
	public void createUserTest() {
		System.out.println("crate user");
		userCreate("tom", 25);
	}
	
	@Test()
	public void updateUserTest() {
		System.out.println("update user");
		userCreate("tom", 25);
		updateCreate("tom", 30);
	}
	
	@Test()
	public void deleteUserTest() {
		System.out.println("delete user");
		userCreate("peter", 25);
		deleteUser("peter", 25);
	}
	
	@Test()
	public void getUserTest() {
		System.out.println("get user");
		userCreate("Lisa", 30);
		getUser("Lisa");
	}
	
	
	
	
	

}
