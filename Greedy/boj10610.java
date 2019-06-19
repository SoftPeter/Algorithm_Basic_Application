package Greedy;

import java.util.*;

public class boj10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int[] num = new int[10];
		int tnum = 0;
		
		for(int i=0; i<number.length(); i++) {
			int temp = number.charAt(i)-48;
			num[temp]++;
			tnum += temp;
		}
		StringBuilder sb = new StringBuilder();
		if(num[0] == 0 || tnum%3 != 0) {
			System.out.println(-1);
		}
		else {
			for(int i=9; i>=0; i--) {
				while(num[i] > 0) {
					sb.append(i);
					num[i]--;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
