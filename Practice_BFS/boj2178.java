package Practice_BFS;

import java.util.*;

class Maze{
	int x;
	int y;
	Maze(int x, int y){
		this.x = x;
		this.y = y;
	}	
}

public class boj2178 {
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		int dist[][] = new int[n][m];
		boolean check[][] = new boolean[n][m];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		Queue<Maze> q = new LinkedList<Maze>();
		q.add(new Maze(0, 0));
		check[0][0] = true;
		dist[0][0] = 1;
		while(!q.isEmpty()) {
			Maze p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny] == 1 && check[nx][ny] == false) {
						q.add(new Maze(nx, ny));
						check[nx][ny] = true;
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
		System.out.println(dist[n-1][m-1]);
	}
}
