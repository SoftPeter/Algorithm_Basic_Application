package Practice_BFS;

import java.util.*;

class Domado{
	int x;
	int y;
	int z;
	Domado(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class boj7569 {
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); //가로 
		int n = sc.nextInt(); //세로 
		int h = sc.nextInt(); //높이 
		int a[][][] = new int[n][m][h];
		int dist[][][] = new int[n][m][h];
		Queue<Domado> q = new LinkedList<>();
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					a[i][j][k] = sc.nextInt();
					dist[i][j][k] = -1;
					if(a[i][j][k] == 1) {
						q.add(new Domado(i, j, k));
						dist[i][j][k] = 0;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Domado p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			for(int k=0; k<6; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				int nz = z+dz[k];
				if(0<=nx && 0<=ny && 0<=nz && nx<n && ny<m && nz<h) {
					if(a[nx][ny][nz]==0 && dist[nx][ny][nz]==-1) {
						q.add(new Domado(nx, ny, nz));
						dist[nx][ny][nz] = dist[x][y][z]+1;
					}
				}
			}
		}
		
		int ans=0;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(ans < dist[i][j][k])
						ans = dist[i][j][k];
				}
			}
		}
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j][k]==0 && dist[i][j][k]==-1)
						ans=-1;
				}
			}
		}
		System.out.println(ans);
	}
}
