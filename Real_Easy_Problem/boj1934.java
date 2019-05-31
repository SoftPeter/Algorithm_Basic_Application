package Real_Easy_Problem;

import java.util.*;

public class boj1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int min = 1;
		int ans = 1;
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int i=1; i<=Math.min(a, b); i++) {
				if(a%i==0 && b%i==0)
					min = i;
			}
			ans = (a/min) * (b/min) * min;
			System.out.println(ans);
		}
	}
}