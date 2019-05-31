package Real_Easy_Problem;

import java.util.*;

public class boj1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 1;
		int check = n;
		
		while(true) {
			int t = n/10;
			int o = n%10;
			int sum = t+o;
			n = o*10 + sum%10;
			if(n == check)
				break;
			else
				cnt++;
		}
		System.out.println(cnt);
	}
}
