package recursive;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW_Java_03_02기_서울_07반_박신원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int N = sc.nextInt();	//배열의 크기 스캔
		int[] arr = new int[N];
		boolean isFound = false;
		
		for (int i = 0; i < N; i++) {
			arr[i]=r.nextInt(100)+1;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int target = sc.nextInt();	//검색할 숫자 입력
		int minIndex=0;
		int maxIndex=N-1;
//		int count=0;
		int current;
		while(!isFound) {
			current = (maxIndex+minIndex)/2;
			if(minIndex>maxIndex) {
				System.out.println(target+ " 검색 실패");
				break;
			}
			if (arr[current]==target) {
				System.out.println(arr[current]+" 검색 성공!");
				isFound=true;
				break;
			}else if (arr[current]>target) {
				maxIndex = current-1;
				
			}else {
				minIndex = current+1;
				
			}
			
//			count++;
		}
		
		
	}

}
