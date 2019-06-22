package Dynamic;

import java.util.*;

public class boj10844 {
	static int div = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long d[][] = new long[n+1][11];
		
		for(int i=1; i<=9; i++) {
			d[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0)
					d[i][j] = d[i-1][j+1] % div;
				else if(j==9)
					d[i][j] = d[i-1][j-1] % div;
				else
					d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % div;
			}
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++)
			ans += d[n][i];
		System.out.println(ans % div);
	}
}
