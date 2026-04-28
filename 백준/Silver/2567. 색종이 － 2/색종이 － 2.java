import java.util.*;
import java.io.*;
public class Main {
	static int N; // 검은 스카프의 수
	static int length; // 둘레 길이
	static int[][] map; // 하얀 천의 영역, 1이면 검은 스카프의 영역을 나타냄
	static boolean[][] visited;
	static int[][] scarfs; // 스카프의 위치들
	static int[] dr = {-1,0,1,0,1,1,-1,-1};
	static int[] dc = {0,-1,0,1,1,-1,1,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[102][102];
		visited = new boolean[101][101];
		int left, down;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken()); // c
			down = Integer.parseInt(st.nextToken()); // r
			fill(down,left); // 검은 스카프 영역 채우기
		}
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(map[i][j] == 0) continue; // 검은천 영역이 아니므로 스킵
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(map[nr][nc] == 0) cnt++; // 8방향에 흰 영역인지 검사
				}
				if(cnt != 0) { // 가장 바깥 영역, 즉 둘레 셀때 쓰는 칸
					map[i][j] = 2;
					length++;
					if(cnt == 2) length++; // 꼭짓점 추가로 세기
				}
			}
		}
		System.out.println(length);
	}
	//검은 스카프 영역 표시
	static void fill(int r ,int c) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i+r][j+c] = 1;
			}
		}
	}
}