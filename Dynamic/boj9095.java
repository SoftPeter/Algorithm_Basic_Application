package Dynamic;

import java.util.*;

public class boj9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int d[] = new int[11];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
//		d[4] = 7;
//		d[5] = 13;
		while(t-- > 0) {
			int n = sc.nextInt();
			for(int i=4; i<=n; i++) {
				d[i] = d[i-1]+d[i-2]+d[i-3];
			}
			System.out.println(d[n]);
		}
		
	}
}
