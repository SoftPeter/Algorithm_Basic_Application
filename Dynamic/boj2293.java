package Dynamic;

import java.util.*;

public class boj2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coin[] = new int[n];
		int d[] = new int[k+1];
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		
		d[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j-coin[i] >= 0) {
					d[j] += d[j-coin[i]];
				}
			}
		}
		System.out.println(d[k]);
	}
}