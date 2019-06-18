package Greedy;

import java.util.*;

public class boj11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n+1];
		int sum = 0;
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=n; i>0 ;i--) {
			sum += k/a[i];
			k %= a[i];
		}
		System.out.println(sum);
	}
}
