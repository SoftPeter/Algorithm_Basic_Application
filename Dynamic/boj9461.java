package Dynamic;

import java.util.*;

public class boj9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		//d1 - d5
		long p[] = new long[101];
		//1, 1, 1, 2, 2, 3, 4, 5, 7, 9
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		p[6] = 3;
		p[7] = 4;
		for(int i=8; i<=100; i++) {
			p[i] = p[i-1] + p[i-5];
		}
		while(t-- > 0) {
			int n = sc.nextInt();
			System.out.println(p[n]);
		}
	}
}
