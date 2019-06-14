package Practice_BFS;

import java.util.*;

class Color{
	int x;
	int y;
	Color(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class boj10026 {
	static int n;
	static String a[][];
	static boolean v[][];
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new String[n][n];
		v = new boolean[n][n];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String s[] = sc.next().split("");
			for(int j=0; j<n; j++) {
				a[i][j] = s[j];
			}
		}
/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
*/
		int count1 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					bfs(i,j,a[i][j]);
					count1++;
				}					
			}
		}
		//System.out.println(count);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				v[i][j] = false;
				if(a[i][j].equals("R")) {
					a[i][j] = "G";
				}
			}
		}
		
		int count2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					bfs(i,j,a[i][j]);
					count2++;
				}					
			}
		}
		System.out.println(count1 + " " + count2);
	}
	static void bfs(int x, int y, String color) {
		Queue<Color> q = new LinkedList<>();
		q.add(new Color(x, y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Color p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(0<=nx && 0 <=ny && nx<n && ny<n) {
					if(a[nx][ny].equals(color) && !v[nx][ny]) {
						q.add(new Color(nx, ny));
						v[nx][ny] = true;
					}
				}
			}
		}
	}
}

