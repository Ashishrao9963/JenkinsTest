package testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({ ITestListenerImpl.class })
@Test(groups = "Smoke")
public class AppTest extends BeforeAfter {

	@Test(dataProviderClass = DataProviders.class,  dataProvider = "AddDoubleValues", groups = "addSub")
	public void addForDouble(double num1, double num2, double expectedResult) throws Exception {
		System.out.println("Entered Test App (Add double)");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().sum(num1, num2);
		Assert.assertEquals(result, expectedResult, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "AddLongValues", groups = "addSub")
	public void addForLong(long a, long b, long c) throws Exception {
		System.out.println("Entered Test App(Add long)");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().sum(a, b);
		Assert.assertEquals(result, c, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class,dataProvider = "MulValues", groups = "mulDiv")
	public void mulForLong(long a, long b, long c) throws Exception {
		System.out.println("Entered Test App(Mul)");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().mult(a, b);
		Assert.assertEquals(result, c, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class,dataProvider = "SubValues", groups = "addSub")
	public void subForDouble(double num1, double num2, double expectedResult) throws Exception {
		System.out.println("Entered Test App(Sub)");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().sub(num1, num2);
		Assert.assertEquals(result, expectedResult, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class,dataProvider = "DivValues", groups = "mulDiv")
	public void divForDouble(double num1, double num2, double expectedResult) throws Exception {
		System.out.println("Entered Test App(Div)");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().div(num1, num2);
		Assert.assertEquals(result, expectedResult, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class,groups = "Expected", expectedExceptions = { ArithmeticException.class, NumberFormatException.class })
	public void divideByZero() {
		System.out.println("Entered Test divideByZero");
		System.out.println("Thread----" + Thread.currentThread().getId());
		double result = new Calculator().div(3, 0);
		Assert.assertEquals(result, 3, "Result doesn't match expected result");
	}
	
	@Test(dataProviderClass = DataProviders.class,groups = "Expected", expectedExceptions = { NullPointerException.class })
	public void stringLength() {
		System.out.println("Entered NullPointerException");
		System.out.println("Thread----" + Thread.currentThread().getId());
		String str = null;
		assert(str.length()>0);
//		str.length();
	}
//	@Test
//	public void iuhefiu() {
//		List<Integer> listOfInts = new ArrayList(Arrays.asList(1,2,3,4,3,4,5,6,7));
//		System.out.println(listOfInts.stream().distinct().toList().equals(listOfInts));
//	}
	
	@Test
	public void iuhefiu() {
//		ArrayList<String> list = new ArrayList(Arrays.asList("Rohith", "ss", "gg", "ss", "hi", "hi","hi","gg"));
//		Map<String, Long> result = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
//				.entrySet().stream().filter(x -> x.getValue() > 1)
//				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
//		System.out.println(result);
		
		
		
		
		List<Integer> listOfInts = new ArrayList(Arrays.asList("a","a","b","ba"));
		listOfInts.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
	}
	
	@Test
	public void jdcuo() {
		List<Integer> listOfInts = new ArrayList(Arrays.asList("a","a","b","ba"));
//		listOfInts.stream().distinct().toList().removeAll(listOfInts);
	}
	
			
	public void uniqueElements() {
		//Get a list of unique elements from a list of elements	
		List<Integer> listOfInts = new ArrayList(Arrays.asList(1,2,3,4,3,4,5,6,7));
	}
	
}