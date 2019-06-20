package Greedy;

import java.util.*;

public class boj1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int pp[] = new int[m];
		int ip[] = new int[m];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++) {
			pp[i] = sc.nextInt();
			ip[i] = sc.nextInt();
		}
		
		Arrays.sort(pp);
		Arrays.sort(ip);
		
		min = Math.min(((n/6)+1)*pp[0], n*ip[0]);
		min = Math.min(min, ((n/6)*pp[0] + (n%6)*ip[0]));
		
		System.out.println(min);
	}
}
