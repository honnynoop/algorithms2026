import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] visit;
	static int[] dr= {-1,0,1, 0};
	static int[] dc= { 0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new int[N][M];
		Queue<int[]> que=new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {//익은토마토
					que.offer(new int[] {i,j});
					visit[i][j]=1;//1에서 시작
				}
			}
		}
		//읽기 끝
		int max=-1;
		//로직
		while(!que.isEmpty()) {// 다음 것 있냐? -> 더 갈곳 있냐?
			int [] cur=que.poll();
			int r=cur[0]; // 현재 위치
			int c=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(!check(nr,nc))continue;
				// 익지 않은 토마토이면서 간적이 없으면 이동가능
				if(map[nr][nc]==0 && visit[nr][nc]==0) {
					map[nr][nc]=1;// 익는다.
					visit[nr][nc]=visit[r][c]+1;//거리나 시간
					que.offer(new int[] {nr,nc});// 시작할 토마토위치
				}
			}
		}
		//익지 않은 토마토가 하나라고 있다면 
		if (hasZero(map)) {
			System.out.println(-1);
		} else {  //모든 토마토가 익었다면 모든 (i,j)값을 비교한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					max=Math.max(max, visit[i][j]);
				}
			}
			System.out.println(max-1);
		}
	}
	private static boolean hasZero(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map2[i][j]==0) return true;
			}
		}
		return false;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	
}
