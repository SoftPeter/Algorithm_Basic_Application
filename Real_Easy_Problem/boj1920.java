package Real_Easy_Problem;

import java.util.*;

public class boj1920 {
	private static int BinarySearch(int[] a, int num) {
		int low = 0;
		int mid = 0;
		int high = a.length-1;
		
		while(low <= high) {
			mid = (low + high)/2;
			
			if(a[mid] == num)
				return 1;
			else if(a[mid] > num)
				high = mid-1;
			else
				low = mid+1;
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			System.out.println(BinarySearch(a, sc.nextInt()));
		}
		
	}
}