import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] maps;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		maps=new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] cs=br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(cs[j]=='x') {
					maps[i][j]=1;
				}
			}
		}
		//시작
		max=0;
		for (int i = 0; i < R; i++) {
			//시작
			if(maps[i][0]==0) {
				//도착
				if(gas(i,0)) { max++;};
			}
				
		}
		System.out.println(max);
	}
	static int[] dr= {-1, 0 ,1};
	static int[] dc= { 1, 1, 1};
	
	static boolean gas(int cr, int cc) {
		//가는 로직 3방향
		for (int d = 0; d < 3; d++) {
			//델타
			int nr=cr+dr[d];
			int nc=cc+dc[d];
			//췌크  범위안??
			if(!check(nr,nc)) continue;
			//파이프를 놓을 수 있니 -> 파이프설치 표시
			//도착했니??
			if(maps[nr][nc]==0) {
				if(nc==C-1) {
					return true;// 도착
				}
				// 표시하지 않으면 시간 터짐
				maps[nr][nc]=2; // 표시 -> 놓은 곳에 파이프 다시 설치불가
				if(gas(nr,nc)) return true;
			}
		}
		// 못가
		return false;
	}
	//췌크  범위안??
	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
