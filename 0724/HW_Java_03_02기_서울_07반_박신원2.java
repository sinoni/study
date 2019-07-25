package recursive;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW_Java_03_02기_서울_07반_박신원2 {
	private static int binarySearch(int[] arr, int target, int maxIndex,int minIndex) {
		if(minIndex>maxIndex) {
			System.out.println(target+" search fail");
			return 0;
		}else {
			int current = (maxIndex+minIndex)/2;
			if(arr[current]==target) {
				System.out.println(target+" search Success");
				return arr[current];
			}
			else if(arr[current]>target) return binarySearch(arr, target, --current, minIndex);
			else return binarySearch(arr, target, maxIndex, ++current);
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] arr = new int[10];
		boolean isFound = false;
		
		for (int i = 0, N=arr.length; i < N; i++) {
			arr[i]=r.nextInt(100)+1;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int target = sc.nextInt();
		binarySearch(arr, target, arr.length+1, 0);

	}
}
