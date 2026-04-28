import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n;
	static int m;
	static int land_num = 0;
	static int[][] b;
	static int[][] dist;
	static boolean[] check;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] order = bf.readLine().split(" ");
		n = Integer.parseInt(order[0]);
		m = Integer.parseInt(order[1]);
		
		b = new int[n][m];

		for(int i = 0; i < n; i++) {
			String[] temp = bf.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				b[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(b[i][j] == 1) {
					land_num++;
					b[i][j] = land_num + 1;
					ArrayList<int[]> a = new ArrayList<int[]>();
					
					a.add(new int[] {i, j});
					while(!a.isEmpty()) {
						int[] temp = a.remove(0);
						
						for(int d = 0; d < 4; d++) {
							int nx = temp[0] + dx[d];
							int ny = temp[1] + dy[d];
							
							if(nx >= 0 && ny >= 0 && nx < n && ny < m && b[nx][ny] == 1) {
								b[nx][ny] = land_num + 1;
								a.add(new int[] {nx, ny});
							}
						}
					}
				}
			}
		}
		
		check = new boolean[land_num];
		dist = new int[land_num][land_num];
		
		for(int i = 0; i < land_num; i++) {
			for(int j = 0; j < land_num; j++) {
				if(i != j)
					dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < n; i++) {
			int st = -1;
			int cnt = 0;
			for(int j = 0; j < m; j++) {
				if(b[i][j] > 0) {
					if(st < 0) {
						st = b[i][j];
					}
					else {
						if(dist[st - 2][b[i][j] - 2] > cnt && cnt > 1) {
							dist[st - 2][b[i][j] - 2] = cnt;
							dist[b[i][j] - 2][st - 2] = cnt;
						}
					
						st = b[i][j];
					}
					cnt = 0;
				}
				else
					cnt++;
			}
		}

		for(int j = 0; j < m; j++) {
			int st = -1;
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				if(b[i][j] > 0) {
					if(st < 0) {
						st = b[i][j];
					}
					else {
						if(dist[st - 2][b[i][j] - 2] > cnt && cnt > 1) {
							dist[st - 2][b[i][j] - 2] = cnt;
							dist[b[i][j] - 2][st - 2] = cnt;
						}
					
						st = b[i][j];
					}
					cnt = 0;
				}
				else
					cnt++;
			}
		}
		
		
		calu(0, 0);
		
		if(result == Integer.MAX_VALUE)
			result = -1;
		
		System.out.println(result);
	}
	
	public static void calu(int cnt, int val) {
		if(val > result)
			return;
		
		if(cnt == land_num) {
			if(result > val)
				result = val;
			return;
		}
		
		for(int i = 0; i < land_num; i++) {
			if(check[i] == false) {
				int temp = Integer.MAX_VALUE;
				
				if(cnt == 0)
					temp = 0;
				else {
					for(int j = 0; j < land_num; j++) {					
						if(check[j] == true && dist[j][i] < temp)
							temp = dist[j][i];
					}
					
					if(temp == Integer.MAX_VALUE)
						continue;
				}
				
				check[i] = true;
				calu(cnt + 1, val + temp);
				check[i] = false;
			}
		}
		
	}
}