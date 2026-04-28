import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] boards;
	static int[] dr = {1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1};
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boards = new char[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				boards[i][j] = st.nextToken().charAt(0);
			}
		}
		int nr, nc;
		//alt : 오목에서 중간인가?, 오목의 왼쪽 끝에서만 체크하기 위함
		int altR, altC;
		for (int c = 0; c < 19; c++) {
			for (int r = 0; r < 19; r++) {
				if (boards[r][c] != '0') {
					for (int i = 0; i < 4; i++) {
						nr = r + dr[i];
						nc = c + dc[i];
						altR = r - dr[i];
						altC = c - dc[i];
						if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19) continue;
						//오목의 중간이 아니라면
						if (altR < 0 || altR >= 19 || altC < 0 || altC >= 19 || boards[nr][nc] != boards[altR][altC]) {
							if (go(r, c, i)) {
								sb.append(boards[r][c]).append("\n").append(r + 1).append(" ").append(c + 1);
								System.out.println(sb.toString());
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(0);
	}
	
	static boolean go(int r, int c, int flag) {
		int nr = r;
		int nc = c;
		//오목 체크
		for (int i = 0; i < 4; i++) {
			nr += dr[flag];
			nc += dc[flag];
			if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19 || boards[nr][nc] != boards[r][c])
				return false;
		}
		//6목 파악
		nr += dr[flag];
		nc += dc[flag];
		//6목 아니면 통과
		if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19 || boards[nr][nc] != boards[r][c])
			return true;
		//6목이면 탈락
		return false;
	}
}