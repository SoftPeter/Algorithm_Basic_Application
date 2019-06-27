package Dynamic;

import java.util.*;

public class boj14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t[] = new int[n+10];
		int p[] = new int[n+10];
		int d[] = new int[n+10];
		
		for(int i=1; i<=n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=1; i<=n+1; i++) {
			d[i] = Math.max(d[i], max);
			d[t[i]+i] = Math.max(d[t[i]+i], p[i]+d[i]);
			max = Math.max(d[i], max);

		}
		System.out.println(max);
		
	}
}
