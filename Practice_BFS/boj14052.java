package Practice_BFS;

import java.util.*;

class Laboratory{
	int x;
	int y;
	Laboratory(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class boj14052 {
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	static int n,m;
	static int[][] a,c;
	static boolean[][] v;
	static int safeCnt = 0;
	static List<Laboratory> list = new ArrayList<>();
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		c = new int[n][m];
		v = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
				// 바이러스 장소 넣어주기
				if(a[i][j] == 2)
					list.add(new Laboratory(i, j));
				else if(a[i][j] == 0)
					safeCnt++;
			}
		}
		// 결과값 초기화
		result = 0;
		solve(0,0,0);
		// 벽을 세우는데 3개를 사용했기 때문에 -3을 해준다.
		System.out.println(result-3);
	}
	
	private static void solve(int x, int y, int cnt) {
		// 벽 3개를 세웠으면 체크하러 가기
		if(cnt == 3) {
			bfs();
			return;
		}
		
		// y index가 범위를 넘겼으면 x를 +1시켜 다음줄로.
		if(y>=m) {
			solve(x+1, 0, cnt);
			return;
		}
		
		// x index가 범위를 넘겼으면 끝.
		if(x>=n)
			return;
		
		// 맵에서 해당 장소가 0 즉, 벽을 세울 수 있다면 세워주자.
		if(a[x][y] == 0) {
			a[x][y] = 1;
			solve(x,y+1,cnt+1);
			a[x][y] = 0;
		}
		
		// 세울 수 없다면 그냥 다음 index로 넘겨주자.
		solve(x, y+1, cnt);
	}
	
	private static void bfs() {
		init(); // 검사전 초기화
		Queue<Laboratory> q = new LinkedList<>();
		int safe = safeCnt;
		// 바이러스 queue에 넣어주기
		for(Laboratory l : list) {
			v[l.x][l.y] = true;
			q.add(l);
		}
		// 바이러스 퍼트리기
		while(!q.isEmpty()) {
			Laboratory l = q.remove();
			int x = l.x;
			int y = l.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(v[nx][ny]) continue;
                if(a[nx][ny]==0) {
                    v[nx][ny] = true;
                    q.add(new Laboratory(nx, ny));
                    safe--; // 안전 범위 개수 감소
                }
			}
		}
		// safe(이번 케이스의 안전 범위 개수)와 전체 값 비교
		result = Math.max(result, safe);
	}
	
	// 검사하기전 맵 & 방문 초기화
	private static void init() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				c[i][j] = a[i][j];
				v[i][j] = false;
			}
		}
	}
}
