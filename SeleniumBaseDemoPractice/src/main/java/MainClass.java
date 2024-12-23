public class MainClass {
	public static void main(String[] args) {
		int[] arr = { 30, 5, 0, 6, 3, 91, 0, 2, 50, 0 };
		int n = arr.length;
		
		
		int nonZeroCount = n-1;
		
		for(int i = n-1 ; i >= 0; i--) {
			if(arr[i]!=0) {
				arr[nonZeroCount] = arr[i];
				nonZeroCount--;
			}	
		}
		for(int i = 0; i<nonZeroCount; i++) {
			arr[i] = 0;
		}
		for(int x:arr) {
			System.out.print(x+" ");
	}
		
		
		
		
//		{ 30, 5, 0, 6, 3, 91, 0, 2, 50, 0 };
//		int nonZeroCount = 0;
//
//		for (int i = 0; i < n; i++) {
//			if (arr[i] != 0) {
//				arr[nonZeroCount++] = arr[i];
//			}
//		}
//		int size = n;
//		for(int i=nonZeroCount-1; i>=0;i--) {
//			arr[--size] = arr[i];
//		}
//		for(int i=0; i<n-nonZeroCount;i++) {
//			arr[i]=0;
//		}
//		for(int x:arr) {
//			System.out.print(x+" ");
//		}
	}
}