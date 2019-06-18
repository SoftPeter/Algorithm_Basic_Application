package Greedy;

import java.util.*;

public class boj11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		int min = 0;
		for(int i=1; i<=n; i++) {
			p[i] = p[i-1]+p[i];
			min += p[i];
		}
		System.out.println(min);
	}
}
