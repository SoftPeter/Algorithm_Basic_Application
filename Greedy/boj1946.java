package Greedy;

import java.util.*;

public class boj1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int s[][] = new int[n+1][2];
			for(int i=1; i<=n; i++) {
				s[i][0] = sc.nextInt();
				s[i][1] = sc.nextInt();
			}
			
			Arrays.sort(s, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1[0], o2[0]);
				}
			});
			
			int pivot = s[1][1];
			int count = 1;
			for(int i=2; i<=n; i++) {
				if(s[i][1] < pivot) {
					pivot = s[i][1];
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
