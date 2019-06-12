package Practice_BFS;

import java.util.*;

class Monoon{
	int y;
	int x;
	Monoon(int y, int x){
		this.y = y;
		this.x = x;
	}	
}

public class boj2583 {
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	static int n,m,k;
	static int a[][];
	static boolean v[][];
	static int sum[];
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n][m];
		v = new boolean[n][m];
		sum = new int[n*m];
		
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					a[x][y] = 1;
				}
			}
		}
		
		int c = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 0 && v[i][j] == false) {
					bfs(i,j,c);
					count++;
					c++;
				}
			}
		}
		System.out.println(count);
		Arrays.sort(sum, 0, count);
		for(int i=0; i<count; i++) {
			System.out.print(sum[i] + " ");
		}
	}
	
	private static void bfs(int y, int x, int c) {
		Queue<Monoon> q = new LinkedList<>();
		q.add(new Monoon(y, x));
		v[y][x] = true;
		while(!q.isEmpty()) {
			Monoon p = q.remove();
			//v[p.y][p.x] = true;
			sum[c] += 1;
			for(int k=0; k<4; k++) {
				int ny = p.y +dy[k];
				int nx = p.x +dx[k];
				
				if(0<=ny && 0<=nx && ny<n && nx<m) {
					if(a[ny][nx] == 0 && !v[ny][nx]) {
						q.add(new Monoon(ny, nx));
						v[ny][nx] = true;
					}
				}
			}
		}
	}
}
