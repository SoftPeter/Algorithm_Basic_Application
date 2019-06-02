package Easy_Dynamic;

import java.util.*;

public class boj1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][3];
		int d[][] = new int[n][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		d[0][0] = a[0][0];
		d[0][1] = a[0][1];
		d[0][2] = a[0][2];
		
		for(int i=1; i<n; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1]; 
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2]; 
		}
		
		int min = Math.min(Math.min(d[n-1][0], d[n-1][1]), d[n-1][2]);
		System.out.println(min);
	}
}
