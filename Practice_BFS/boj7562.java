package Practice_BFS;

import java.util.*;

class Horse {
	int x;
	int y;
	Horse(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj7562 {
	static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
	static int l;
	static boolean v[][];
	static int des_x, des_y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			l = sc.nextInt();
			v = new boolean[l][l]; // 체스판
			int now_x = sc.nextInt(); // 현재 x좌표
			int now_y = sc.nextInt(); // 현재 y좌표

			des_x = sc.nextInt(); // 도달해야 하는 x좌표
			des_y = sc.nextInt(); // 도달해야 하는 y좌표
			int cnt = 0;
			System.out.println(bfs(now_x, now_y, cnt));
		}

	}
	private static int bfs(int x, int y, int cnt) {
		Queue<Horse> q = new LinkedList<Horse>();
		q.add(new Horse(x, y));
		//v[x][y] = true;
		while (!q.isEmpty()) {
			int q_size = q.size();
			//System.out.print(q_size + " ");
			for (int i = 0; i < q_size; i++) {
				Horse p = q.remove();
				x = p.x;
				y = p.y;
				if (x == des_x && y == des_y) {
					return cnt;
				}
				for (int k = 0; k < 8; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (0 <= nx && 0 <= ny && nx < l && ny < l) {
						if (v[nx][ny] == false) {
							q.add(new Horse(nx, ny));
							v[nx][ny] = true;
						}
					}
				}

			}
			cnt++;
		}
		return cnt;
	}
}
