package Dynamic;

import java.util.*;

public class boj9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			long a[][] = new long[2][n+1];
			for(int i=0; i<2; i++) {
				for(int j=0; j<n; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			long d[][] = new long[3][n+1];
			for(int i=1; i<=n; i++) {
				d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
				d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + a[0][i-1];
				d[2][i] = Math.max(d[0][i-1], d[1][i-1]) + a[1][i-1];
			}
			
			System.out.println(Math.max(d[0][n], Math.max(d[1][n], d[2][n])));

		}
	}
}
