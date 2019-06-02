package Easy_Dynamic;

import java.util.*;

public class boj2294 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int v[] = new int[n+1];
		int d[] = new int[k+1];
		
		d[0] = 0;
		for(int i=1; i<=k; i++) {
			d[i] = 100001;
		}
		
		for(int i=1; i<=n; i++) {
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=v[i]; j<=k; j++) {
				d[j] = Math.min(d[j], d[j-v[i]]+1);
			}
		}

		if(d[k] == 100001) {
			d[k] = -1;
		}
		
		System.out.println(d[k]);
	}
}
