package Practice_BFS;

import java.util.*;

class Water{
	int x;
	int y;
	Water(int x, int y){
		this.x = x;
		this.y = y;
	}	
}

public class boj2468 {
	static int n, max_high, cnt, ans;
	static int a[][];
	static boolean v[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		v = new boolean[n][n];
		max_high = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = sc.nextInt();
				if(max_high < a[i][j])
					max_high = a[i][j];
			}
		}
		
		ans=0;
		cnt=0;
		for(int k=0; k<max_high; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(a[i][j] > k && !v[i][j]) {
						bfs(i,j,k);
						cnt++;
					}
				}
			}
			for(int i = 0 ; i< n; i++) {
				for(int j =0; j< n; j++) {
					v[i][j] = false;
				}
			}
			if(ans < cnt)
				ans = cnt;
			//System.out.println("k = " +k +" cnt = " +cnt);
			cnt = 0;
			
		}
		System.out.println(ans);
	}
	
	static void bfs(int x, int y, int high) {
		Queue<Water> q = new LinkedList<>();
		q.add(new Water(x, y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Water p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && 0<=ny && nx < n && ny < n) {
					if(a[nx][ny] > high && !v[nx][ny]) {
						q.add(new Water(nx, ny));
						v[nx][ny] = true;
					}
				}
			}
		}
	}
}