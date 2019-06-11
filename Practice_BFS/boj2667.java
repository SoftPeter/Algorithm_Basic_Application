package Practice_BFS;

import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class boj2667 {
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		sc.nextLine();
		
		int m[][] = new int[n][n];
		int v[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<n; j++) {
				m[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(m[i][j] == 1 && v[i][j] == 0) {
					bfs(m, v, i, j, ++cnt, n);
				}
			}
		}
		
		int[] ans = new int[cnt];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(v[i][j] != 0)
					ans[v[i][j]-1] += 1;
			}
		}
		Arrays.sort(ans);
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(ans[i]);
		}
	}
	
	static void bfs(int[][] m, int[][] v, int x, int y, int cnt, int n) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		v[x][y] = cnt;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(m[nx][ny] == 1 && v[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						v[nx][ny] = cnt;
					}
				}
			}
		}
		
	}
}
