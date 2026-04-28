import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][][] visited; // {r, c, (가로 0 , 세로 1)}
	static int N;
	static int[] start; // {r, c, 가로세로}
	static int[] end;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], 1);
		}
		visited = new boolean[N + 2][N + 2][2];
		
		char[] a;
		boolean findStart = true, findEnd = true;
		for (int i = 1; i < N + 1; i++) { // 맵 저장
			a = br.readLine().toCharArray();
			for (int j = 1; j < N + 1; j++) {
				if (a[j - 1] == 'B') {
					map[i][j] = 0;
					if (findStart) {
						if (j < N - 1 && a[j] == 'B') { // 가로
							start = new int[] {i, j + 1, 0};
						}else { // 세로
							start = new int[] {i + 1, j, 1};
						}
						findStart = false;
					}
				}else if (a[j - 1] == 'E') {
					map[i][j] = 0;
					if (findEnd) {
						if (j < N - 1 && a[j] == 'E') { // 가로
							end = new int[] {i, j + 1, 0};
						}else { // 세로
							end = new int[] {i + 1, j, 1};
						}
						findEnd = false;						
					}			
				}else if (a[j - 1] == '0') {
					map[i][j] = 0;
				}
			}
		} // 맵 저장 끝

		bfs();
		
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start[0], start[1], start[2], 0});
		visited[start[0]][start[1]][start[2]] = true;
		
		int[] s;
		int r, c, hv, count;
		while(!q.isEmpty()) {
			s = q.poll();
			r = s[0]; c = s[1]; hv = s[2]; count = s[3];
			
			if (r == end[0] && c == end[1] && hv == end[2]) { // 끝
				System.out.println(count);
				return;
			}
			
			if (hv == 0) { // 가로
				if (map[r - 1][c - 1] == 0 && map[r - 1][c] == 0 && map[r - 1][c + 1] == 0 && !visited[r - 1][c][0]) {
					// 위
					q.add(new int[] {r - 1, c, 0, count + 1});
					visited[r - 1][c][0] = true;
				}
				if (map[r + 1][c - 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && !visited[r + 1][c][0]) {
					// 아래
					q.add(new int[] {r + 1, c, 0, count + 1});
					visited[r + 1][c][0] = true;
				}
				if (map[r][c + 2] == 0 && !visited[r][c + 1][0]) {
					// 오른쪽
					q.add(new int[] {r, c + 1, 0, count + 1});
					visited[r][c + 1][0] = true;
				}
				if (map[r][c - 2] == 0 && !visited[r][c - 1][0]) {
					// 왼쪽
					q.add(new int[] {r, c - 1, 0, count + 1});
					visited[r][c - 1][0] = true;
				}
				if (map[r - 1][c - 1] == 0 && map[r - 1][c] == 0 && map[r - 1][c + 1] == 0 && map[r + 1][c - 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && !visited[r][c][1]) {
					// 회전
					q.add(new int[] {r, c, 1, count + 1});
					visited[r][c][1] = true;
				}
			}else if (hv == 1) { // 세로
				if (map[r - 2][c] == 0 && !visited[r - 1][c][1]) {
					// 위
					q.add(new int[] {r - 1, c, 1, count + 1});
					visited[r - 1][c][1] = true;
				}
				if (map[r + 2][c] == 0 && !visited[r + 1][c][1]) {
					// 아래
					q.add(new int[] {r + 1, c, 1, count + 1});
					visited[r + 1][c][1] = true;
				}
				if (map[r - 1][c - 1] == 0 && map[r][c - 1] == 0 && map[r + 1][c - 1] == 0 && !visited[r][c - 1][1]) {
					// 왼쪽
					q.add(new int[] {r, c - 1, 1, count + 1});
					visited[r][c - 1][1] = true;
				}
				if (map[r - 1][c + 1] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && !visited[r][c + 1][1]) {
					// 오른쪽
					q.add(new int[] {r, c + 1, 1, count + 1});
					visited[r][c + 1][1] = true;
				}
				if (map[r - 1][c - 1] == 0 && map[r][c - 1] == 0 && map[r + 1][c - 1] == 0 &&map[r - 1][c + 1] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && !visited[r][c][0]) {
					// 회전
					q.add(new int[] {r, c, 0, count + 1});
					visited[r][c][0] = true;
				}
			}
		}
		System.out.println(0);
	}

}