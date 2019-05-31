package Real_Easy_Problem;

import java.util.*;

public class boj1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ans = 1;
			for(int i=0; i<b; i++) {
				ans = (ans * a) % 10;
				if(ans == 0)
					ans = 10;
			}
			System.out.println(ans);
		}
	}
}
