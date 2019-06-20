package Greedy;

import java.util.*;

public class boj1138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tall[] = new int[n+1];
		List<Integer> ans = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			tall[i] = sc.nextInt();
		}
		
		for(int i=n; i>=1; i--) {
			ans.add(tall[i], i);
		}
		
		for(int k : ans) {
			System.out.print(k + " ");
		}
	}
}
