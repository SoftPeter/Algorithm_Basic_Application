package Greedy;

import java.util.*;

public class boj2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rope[] = new int[n];
		for(int i=0; i<n; i++) {
			rope[i] = sc.nextInt();
		}
		
		Arrays.sort(rope);
		
		int sum=0;
		for(int i=n-1; i>=0; i--) {
			if(sum < rope[i]*(n-i))
				sum = rope[i]*(n-i);
		}
		System.out.println(sum);
	}
}
