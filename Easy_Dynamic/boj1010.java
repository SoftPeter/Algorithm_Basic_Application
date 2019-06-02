package Easy_Dynamic;

import java.util.*;

public class boj1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int d[][] = new int[n+1][m+1];
			for(int i=0; i<=m; i++)
				d[1][i] = i;
			
			for(int i=2; i<=n; i++)
				for(int j=i; j<=m; j++)
					for(int k=j; k>=i; k--)
						d[i][j] += d[i-1][k-1];

			System.out.println(d[n][m]);
		}
	}
}
