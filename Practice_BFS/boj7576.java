package Practice_BFS;

import java.util.*;

class Tomato{
	int x;
	int y;
	Tomato(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class boj7576 {
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); //가로 
		int n = sc.nextInt(); //세로 
		int a[][] = new int[n][m];
		int dist[][] = new int[n][m];
		Queue<Tomato> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
				dist[i][j] = -1;
				if(a[i][j] == 1) {
					q.add(new Tomato(i,j));
					dist[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny]==0 && dist[nx][ny]==-1) {
						q.add(new Tomato(nx, ny));
						dist[nx][ny] = dist[x][y]+1;
					}
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ans < dist[i][j])
					ans = dist[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 0 && dist[i][j] == -1)
					ans = -1;
			}
		}
		System.out.println(ans);
	}
}
