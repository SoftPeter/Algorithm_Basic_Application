package Greedy;

import java.util.*;

public class boj5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c[] = {500, 100, 50, 10, 5, 1};
		int m = 1000-n;
		int sum = 0;
		for(int i=0; i<c.length; i++) {
			sum += m/c[i];
			m %= c[i];
		}
		System.out.println(sum);
	}
}
