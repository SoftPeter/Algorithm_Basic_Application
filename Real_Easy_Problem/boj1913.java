package Real_Easy_Problem;

import java.util.*;

public class boj1913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans = sc.nextInt();
		int a[][] = new int[t][t];
		int first = 0;
		int last = t-1;
		int plag = t/2;
		int value = t*t;
		
		while(plag >= 0) {
			for(int i=first; i<=last; i++) {
				a[i][first] = value;
				value--;
			}
			first++;
			for(int j=first; j<=last; j++) {
				a[last][j] = value;
				value--;
			}
			for(int k=last-1; k>=first-1; k--) {
				a[k][last] = value;
				value--;
			}
			last--;
			for(int l=last; l>=first; l--) {
				a[first-1][l] = value;
				value--;
			}
			plag--;
		}
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<t; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<t; j++) {
				if(a[i][j] == ans)
					System.out.println((i+1) + " " + (j+1));
			}
		}
	}
}