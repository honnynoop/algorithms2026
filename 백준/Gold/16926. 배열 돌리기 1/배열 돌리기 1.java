import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0, N-1, 0, M-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void move(int x1, int x2, int y1, int y2) {
		if(x1>x2 | y1>y2) return;
		int r = R%(2*(x2-x1+y2-y1));
		while(r-->0) {
			int end = map[x1][y1];
			for(int i = y1; i < y2; i++) {
				map[x1][i] = map[x1][i+1];
			}
			for(int i = x1; i < x2; i++) {
				map[i][y2] = map[i+1][y2];
			}
			for(int i = y2; i > y1; i--) {
				map[x2][i] = map[x2][i-1];
			}
			for(int i = x2; i > x1; i--) {
				map[i][y1] = map[i-1][y1];
			}
			map[x1+1][y1] = end;
		}
		
		move(x1+1, x2-1, y1+1, y2-1);
	}

}