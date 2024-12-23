package testng;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "AddDoubleValues")
	public Object[][] returnDoubleValues() {
		System.out.println("Entered Double Addition 2D array");
		return new Object[][] {
			{ 5.5, 4.5, 10 },
			{ 2.3, 3.2, 5.5 }
//    		{3,6.3,9.3},
//    		{12.2,2233,2245.2},
//    		{2,2.8,4.8},
//    		{34,22,11},
//    		{123,123,1245},
//    		{938,38,12234},
//    		{123,45,161},
//    		{478,89,23}
		};
	}
	
	@DataProvider(name = "AddLongValues")
	public Object[][] returnIntValues() {
		System.out.println("Entered Long Addition 2D array");
		return new Object[][] {
			{ 1, 2, 3 },
			{ 2, 3, 5 }
//    		{3,6,9},
//    		{12,2233,2245},
//    		{2,2,4},
//    		{34,22,11},
//    		{123,123,1245},
//    		{938,38,12234},
//    		{123,45,161},
//    		{478,89,23}
		};
	}
	
	@DataProvider(name = "DivValues")
	public Object[][] returnValuesForDiv() {
		System.out.println("Entered Double Division 2D array");
		return new Object[][] {
			{ 2, 1, 2 },
			{ 7, 2, 3.5 }
//    		{81,9,9},
//    		{64,16,4},
//    		{2.2,2,1.1},
//    		{1,2,4},
//    		{2.2,2.2,18},
//    		{2,3000,10900},
//    		{12,4,49},
//    		{22,7,12}
		};
	}
	
	@DataProvider(name = "SubValues")
	public Object[][] returnValuesForSub() {
		System.out.println("Entered Double Subraction 2D array");
		return new Object[][] {
			{ 3, 2, 1 },
			{ 2.2, 2.2, 0}
//    		{7,3.5,3.5},
//    		{6,3,3},
//    		{9,6,3},
//    		{4,2,1},
//    		{2.2,2.2,2},
//    		{4000,3000,10900},
//    		{1200,4,49},
//    		{22,7,12}
		};
	}
	

	@DataProvider(name = "MulValues")
	public Object[][] returnValuesForMul() {
		System.out.println("Entered Long Multiplication 2D array");
		return new Object[][] {
			{ 1, 2, 2 },
			{ 3, 4, 12}
//    		{2,3,6},
//    		{4,2,8},
//    		{3,6,18},
//    		{1,2,65},
//    		{23,2,469},
//    		{2,3000,10900},
//    		{12,4,49},
//    		{22,7,12}
		};
	}
	
}