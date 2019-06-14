package Practice_BFS;

import java.util.*;

class Treasure{
	int x;
	int y;
	Treasure(int x, int y){
		this.x = x;
		this.y = y;
	}	
}

public class boj2589 {
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	static int h, w;
	static boolean v[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		String [][]a = new String[h][w];
		v = new boolean[h][w];
		sc.nextLine();
		for(int i=0; i<h; i++) {
			String s = sc.nextLine();
			for(int j=0; j<w; j++) {
				a[i][j] = s.substring(j, j+1);
			}
		}
		
		int ans=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				int max=0;
				if(a[i][j].equals("L")) {
					max = bfs(i,j,a);
				}
				if(ans < max)
					ans = max;
			}
		}
		System.out.println(ans);
	}
	
	static int bfs(int x, int y, String a[][]) {
		// TODO Auto-generated method stub
		String copy[][] = new String[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				copy[i][j] = a[i][j];
			}
		}
		
		int dist[][] = new int[h][w];
		Queue<Treasure> q = new LinkedList<>();
		q.add(new Treasure(x, y));
		//v[x][y] = true;
		copy[x][y] = "x";
		dist[x][y] = 0;
		while(!q.isEmpty()) {
			Treasure p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && 0<=ny && nx<h && ny<w) {
					if(copy[nx][ny].equals("L") ) {
						q.add(new Treasure(nx, ny));
						//v[nx][ny] = true;
						copy[nx][ny] = "x";
						dist[nx][ny] = dist[x][y]+1;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (max < dist[i][j])
					max = dist[i][j];
			}
		}
		return max;
	}
}
