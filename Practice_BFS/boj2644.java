package Practice_BFS;

import java.util.*;

public class boj2644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = sc.nextInt();
		int end = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[101][101];
		int d[] = new int[101];
		boolean v[] = new boolean[101];
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x][y] = a[y][x] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		v[start] = true;
		while(!q.isEmpty()) {
			int now = q.remove();
			for(int i=1; i<=n; i++) {
				if(a[now][i]==1 && !v[i]) {
					q.add(i);
					d[i] = d[now]+1;
					v[i]=true;
				}
			}
		}
		if(d[end] == 0)
			System.out.println(-1);
		else
			System.out.println(d[end]);
	}
}