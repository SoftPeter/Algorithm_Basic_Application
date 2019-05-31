package Real_Easy_Problem;

import java.util.*;

public class boj1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String day[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int m = sc.nextInt();
		int d = sc.nextInt();
		int sum=0;
		for(int i=0; i<m-1; i++) {
			sum += month[i];
		}
		sum += d;
		System.out.println(day[sum%7]);
	}
}