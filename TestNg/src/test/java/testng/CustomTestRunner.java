package testng;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class CustomTestRunner {
	public static void main(String[] args) {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG tng = new TestNG();
		tng.setTestClasses(new Class[] {AppTest.class});
		tng.addListener(tla);
		tng.run();
		
	}
}